package com.buyconnex.buyconnex.controller.account;

import com.buyconnex.buyconnex.controller.utils.DefaultApi;
import com.buyconnex.buyconnex.entity.security.ResetPasswordToken;
import com.buyconnex.buyconnex.entity.security.VerificationTokenMfa;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.entity.utils.Files;
import com.buyconnex.buyconnex.exception.UserNotFoundException;
import com.buyconnex.buyconnex.service.user.IUserSettingService;
import com.buyconnex.buyconnex.service.utils.IFileService;
import com.buyconnex.buyconnex.service.utils.IMailService;
import com.buyconnex.buyconnex.utils.MiscUtils;
import com.buyconnex.buyconnex.vo.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApi extends DefaultApi {

    @NonNull
    private IMailService mailService;

    @NonNull
    private JavaMailSender javaMailSender;

    @NonNull
    private IUserSettingService userSettingService;

    @NonNull
    private IFileService fileService;

    @NonNull
    private MiscUtils miscUtils;

    @PostMapping("/reset-password")
    public GenericResponseVo resetPassword(HttpServletRequest request, @RequestParam("email") String userMail) {
        Optional<Users> users = userService.getUsersByEmail(userMail);
        if (!users.isPresent()) {
            throw new UserNotFoundException();
        }
        Locale locale = userSettingService.getLangueSettingByEmail(userMail);
        String token = UUID.randomUUID().toString();
        userService.createResetPasswordTokenForUser(users.get(), token);
        javaMailSender.send(mailService.constructResetTokenEmail(miscUtils.getUrlApp(/*request*/), locale, token, users.get()));
        return new GenericResponseVo(messageSource.getMessage("message.resetPassword.email", null, LocaleContextHolder.getLocale()));
    }

    @PostMapping("/check-token-reset-password")
    public GenericResponseVo checkTokenResetPassword(@RequestParam("token") String token) {
        String result = userService.validatePasswordResetToken(token);
        if (result != null) {
            return new GenericResponseVo(messageSource.getMessage("auth.message." + result, null, LocaleContextHolder.getLocale()), HttpStatus.SC_FORBIDDEN);
        }
        return new GenericResponseVo("", HttpStatus.SC_OK);
    }

    @PostMapping("/update-password")
    public GenericResponseVo changeUserPassword(@RequestBody NewPasswordVo newPasswordVo) {
        ResetPasswordToken resetPasswordToken = userService.findUserByResetPasswordToken(newPasswordVo.getToken());
        if (resetPasswordToken != null && resetPasswordToken.getUsers() != null) {
            userService.changeUserPassword(resetPasswordToken, newPasswordVo.getPassword());
            return new GenericResponseVo(messageSource.getMessage("message.update.password.modif", null, LocaleContextHolder.getLocale()), HttpStatus.SC_OK);
        }
        return new GenericResponseVo(messageSource.getMessage("auth.message.invalide.token", null, LocaleContextHolder.getLocale()), HttpStatus.SC_FORBIDDEN);
    }

    @PostMapping("/mfa")
    public ResponseEntity<AuthResponseVo> mfa(@RequestParam("otp") String otp) {
        Optional<VerificationTokenMfa> verificationTokenMfa = userService.validateOtpLogin(otp);
        if (verificationTokenMfa.isPresent()) {
            AuthResponseVo responseVo = new AuthResponseVo();
            responseVo.setAccesToken(verificationTokenMfa.get().getToken());
            Set<String> roles = verificationTokenMfa.get().getUsers().getRoles().stream().map(r -> r.getRoleName()).collect(Collectors.toSet());
            responseVo.setRoles(roles.stream().collect(Collectors.toList()));
            responseVo.setCurrentLogin(verificationTokenMfa.get().getUsers().getLogin());
            userService.deleteAllOtpByUser(verificationTokenMfa.get().getUsers());
            return new ResponseEntity<AuthResponseVo>(responseVo, org.springframework.http.HttpStatus.OK);
        }
        return null;
    }

    @GetMapping("/profile-user")
    public ResponseEntity<ContactVo> profileUser(Principal principal) {
        Optional<Users> users = userService.getUsersByUserLogin(principal.getName());
        if (users.isPresent()) {
            ContactVo contactVo = new ContactVo();
            contactVo.setLogin(users.get().getLogin());
            contactVo.setFirstName(users.get().getContacts().getFirstName());
            contactVo.setLastName(users.get().getContacts().getLastName());
            contactVo.setEmail(users.get().getContacts().getEmail());
            contactVo.setTelephone(users.get().getContacts().getTelephone1());
            return new ResponseEntity<ContactVo>(contactVo, org.springframework.http.HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("/profile-reset-password")
    public GenericResponseVo resetUserPassword(@RequestBody NewPasswordVo newPasswordVo) {
        Optional<Users> users = userService.getUsersByUserLogin(newPasswordVo.getToken());
        if (users.isPresent()) {
            ResetPasswordToken resetPasswordToken = new ResetPasswordToken();
            resetPasswordToken.setUsers(users.get());
            userService.changeUserPassword(resetPasswordToken, newPasswordVo.getPassword());
            return new GenericResponseVo(messageSource.getMessage("message.update.password.modif", null, LocaleContextHolder.getLocale()), HttpStatus.SC_OK);
        }
        return new GenericResponseVo(messageSource.getMessage("auth.message.invalide.token", null, LocaleContextHolder.getLocale()), HttpStatus.SC_FORBIDDEN);
    }

    @GetMapping(path = {"/profile-user/img"})
    public ResponseEntity<ImgVo> getProfilImg(Principal principal) throws IOException {
        Optional<Users> users = userService.getUsersByUserLogin(principal.getName());
        if (users.isPresent()) {
            Files profilImg = fileService.findFileByOwnerId(users.get().getId());
            if (profilImg != null) {
                ImgVo img = new ImgVo(profilImg.getFileName(), profilImg.getMimeType(), null, null, null, profilImg.getTheBlob());
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + img.getName())
                        .body(img);
            }
        }
        return ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"null")
                .body(null);

    }

    @PostMapping("/profile-user/img")
    @Transactional
    public ResponseEntity uploadProfileImg(@RequestParam("file")MultipartFile file, Principal principal) {
        Optional<Users> users = userService.getUsersByUserLogin(principal.getName());
        if (users.isPresent() && !file.isEmpty()) {
            try {
                fileService.deleteFileByOwnerId(users.get().getId());
                byte[] fileContent = file.getBytes();
                Files files = new Files();
                files.setOwner1_id(users.get().getId());
                files.setTheBlob(fileContent);
                files.setFileName(users.get().getId().toString());
                files.setAbreviation(users.get().getId().toString());
                files.setFileSize(file.getSize());
                files.setMimeType(file.getContentType());
                files.setDateUpload(new Date());
                fileService.saveFiles(files);
                return ResponseEntity.ok(new GenericResponseVo(messageSource.getMessage("user.profil.img.upload.succes", null, LocaleContextHolder.getLocale()), org.springframework.http.HttpStatus.OK.value()));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.internalServerError().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
