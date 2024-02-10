package com.buyconnex.buyconnex.controller.account;

import com.buyconnex.buyconnex.controller.utils.DefaultApi;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.entity.utils.Settings;
import com.buyconnex.buyconnex.service.setting.ISettingService;
import com.buyconnex.buyconnex.service.utils.IMailService;
import com.buyconnex.buyconnex.vo.MailVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.internet.MimeMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ContactApi extends DefaultApi {

    private static final Logger logger = LoggerFactory.getLogger(ContactApi.class);

    @NonNull
    private IMailService mailService;

    @NonNull
    private JavaMailSender javaMailSender;

    @NonNull
    private ISettingService settingService;

    @PostMapping(path = "/contact/send-email", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity sendMessage(MultipartHttpServletRequest request, Principal principal) {
        try {
            if (request.getParameter("mailVo") != null) {
                Optional<Users> users = getUser(principal);
                Settings emailContactSetting = settingService.getEmailContact();
                if (users.isPresent() && emailContactSetting != null && emailContactSetting.getValueStr() != null && !emailContactSetting.getValueStr().isEmpty()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    MailVo mailVo = objectMapper.readValue(request.getParameter("mailVo"), MailVo.class);
                    MultipartFile file = request.getFile("pj");
                    if (file != null) {
                        mailVo.setPj(file.getBytes());
                    }
                    MimeMessage msg = mailService.constructEmailContact(mailVo, emailContactSetting.getValueStr(), users.get());
                    javaMailSender.send(msg);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
