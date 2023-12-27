package com.buyconnex.buyconnex.controller.security;

import com.buyconnex.buyconnex.configuration.JwtConfiguration;
import com.buyconnex.buyconnex.controller.utils.DefaultApi;
import com.buyconnex.buyconnex.entity.security.VerificationTokenMfa;
import com.buyconnex.buyconnex.entity.user.UserSettings;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.entity.utils.Settings;
import com.buyconnex.buyconnex.exception.InvalidUserException;
import com.buyconnex.buyconnex.service.setting.ISettingParams;
import com.buyconnex.buyconnex.service.setting.SettingService;
import com.buyconnex.buyconnex.service.user.IUserService;
import com.buyconnex.buyconnex.service.user.UserSettingService;
import com.buyconnex.buyconnex.service.utils.IMailService;
import com.buyconnex.buyconnex.vo.AuthRequestVo;
import com.buyconnex.buyconnex.vo.AuthResponseVo;
import com.buyconnex.buyconnex.vo.UserSettingVo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.auth.InvalidCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JwtAuthApi extends DefaultApi {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthApi.class);

    @NonNull
    private JwtConfiguration jwtConfiguration;

    @NonNull
    private IUserService userService;

    @NonNull
    private AuthenticationManager authenticationManager;

    @NonNull
    private JavaMailSender javaMailSender;

    @NonNull
    private IMailService mailService;

    @NonNull
    private UserSettingService userSettingService;

    @NonNull
    private SettingService settingService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponseVo> generateJwtToken(@RequestBody AuthRequestVo authRequestVo) {

        Authentication authentication = null;
        AuthResponseVo authResponseVo = new AuthResponseVo();

        Settings isInactif = settingService.getSettingById(ISettingParams.SETTING_DESACTIVER_ACCES_BOOL);
        if (isInactif != null && isInactif.getValueBool() != null && isInactif.getValueBool().booleanValue()) {
            return new ResponseEntity<AuthResponseVo>(authResponseVo, HttpStatus.SERVICE_UNAVAILABLE);
        }

        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestVo.getLogin(), authRequestVo.getPassword()));

            User user = (User) authentication.getPrincipal();
            Set<String> roles = user.getAuthorities().stream().map(u -> u.getAuthority()).collect(Collectors.toSet());
            String token = jwtConfiguration.generateToken(authentication);
            authResponseVo.setAccesToken(token);
            authResponseVo.setRoles(roles.stream().collect(Collectors.toList()));
            //Charger les settings du user
            UserSettings userSettings = userSettingService.getUserSettingByUser(authRequestVo.getLogin());
            UserSettingVo userSettingVo = new UserSettingVo();
            userSettingVo.setNotifActive(userSettings != null ? userSettings.isNotifActive() : false);
            userSettingVo.setMfaActive(userSettings != null ? userSettings.isMfaActive() : false);
            userSettingVo.setLangue(userSettings != null ? userSettings.getLangue() : userSettingVo.getDefaultLangue());
            authResponseVo.setUserSettingVo(userSettingVo);

            if (userSettingVo.isMfaActive()) {
                VerificationTokenMfa verificationTokenMfa = userService.createOtpForUser(authRequestVo.getLogin(), token);
                if (verificationTokenMfa != null) {
                    authResponseVo.setUserEmail(verificationTokenMfa.getUsers().getContacts().getEmail());
                    javaMailSender.send(mailService.constructOtpConnectEmail(userSettingService.getLangueSettingByUserSetting(userSettings), verificationTokenMfa.getMfaCode(), verificationTokenMfa.getUsers()));
                } else {
                    throw new InvalidUserException("Invalid Credentials");
                }
            }
            logger.info("Authentication : User existe");
            return new ResponseEntity<AuthResponseVo>(authResponseVo, HttpStatus.OK);
        } catch (DisabledException e) {
            logger.error("User inactive", e);
            return new ResponseEntity<AuthResponseVo>(authResponseVo, HttpStatus.FORBIDDEN);
        } catch (MailException e) {
            logger.error("Erreur lors de l'envoi de mail {}", e);
            return new ResponseEntity<AuthResponseVo>(authResponseVo, HttpStatus.OK);
        }
    }

    private final String getClientIP(HttpServletRequest request) {
        final String xfHeader = request.getHeader("X-Forwaded-For");
        if (xfHeader == null || xfHeader.isEmpty() || !xfHeader.contains(request.getRemoteAddr())) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }


}
