package com.buyconnex.buyconnex.service.utils;

import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.entity.utils.Settings;
import com.buyconnex.buyconnex.service.setting.ISettingService;
import com.buyconnex.buyconnex.vo.MailVo;
import jakarta.mail.internet.MimeMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.eclipse.angus.mail.iap.ByteArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.text.StrSubstitutor;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailService implements IMailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    @NonNull
    private MessageSource messages;

    @NonNull
    private Environment env;

    @NonNull
    private ISettingService settingService;

    @NonNull
    private JavaMailSender javaMailSender;

    @Override
    public SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale, final String token, final Users users) {
        String[] params = buildParams((users.getContacts().getLastName() != null ? users.getContacts().getLastName() : "").concat("").concat(users.getContacts().getFirstName()),
                contextPath + "/auth/newpassword?token=" + token);
        final String message = messages.getMessage("message.resetPassword", params, locale);
        logger.info("Demande de réinitialisation de votre mot de passe envoyé à l'utilisateur : {}", users.getUserLogin());
        return contructEmail(messages.getMessage("message.resetPassword.email", null, locale), message, users);
    }

    public SimpleMailMessage constructOtpConnectEmail(final Locale locale, String codeOtp, final Users users) {
        String[] params = buildParams((users.getContacts().getLastName() != null ? users.getContacts().getLastName() : "").concat("").concat(users.getContacts().getFirstName()), codeOtp);
        final String message = messages.getMessage("message.send.otp", params, locale);
        logger.info("Demande d'authentification avec OTP envoyé à l'utilisateur : {}", users.getUserLogin());
        return contructEmail(messages.getMessage("message.code.otp", null, locale), message, users);
    }

    @Override
    public MimeMessage constructCreateAccountTokenEmail(final String contextPath, final Locale locale, final String token, final Users users) {
        String[] params = buildParams( users.getContacts().getFirstName().concat("").concat(users.getContacts().getFirstName()),
                contextPath + "/auth/newpassword?token=" + token);
        Settings mailCoprs = settingService.getEmailCreationCorpsCount();
        Settings mailObject = settingService.getEmailCreationObjectCount();
        Map<String, String> map = new HashMap<String, String>();
        map.put("UTILISATEUR", users.getContacts().getLastName() != null ? users.getContacts().getLastName() : "").concat("").concat(users.getContacts().getFirstName());
        map.put("URL_D_CONNEXION", (contextPath + "/auth/newpassword?token=" + token));

        logger.info("Demande de création de compte envoyé à l'utilisateur : {}", users.getUserLogin());

        String corpsEmail = mailCoprs.getValueClobSetting();
        if (corpsEmail != null) {
            corpsEmail = corpsEmail.replace("<br>", "\n");
        }
        return constructHtmlEmail(mailObject.getValueStr() != null ? mailObject.getValueStr() : mailObject.getDefaultValueStr(),
                StrSubstitutor.replace(mailCoprs.getValueClobSetting(), map), users);
    }

    @Override
    public MimeMessage constructEmailContact(MailVo mailVo, String contactEmail, Users users) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(contactEmail);
            helper.setTo(contactEmail);
            helper.setSubject(mailVo.getSujet().concat(" - ").concat(users.getContacts().getLastName() + " " + users.getContacts().getFirstName()));
            String msg = mailVo.getMessage() != null ? mailVo.getMessage() : "";
            msg = msg.concat("\n \n \n " + users.getContacts().getLastName() + " " + users.getContacts().getFirstName());
            msg = msg.concat("\n " + users.getUserLogin() + " \n " + users.getContacts().getTelephone1());
            helper.setText(msg);
            if (mailVo.getPj() != null) {
                ByteArrayResource byteArrayResource = new ByteArrayResource(mailVo.getPj());
                helper.addAttachment(mailVo.getJpName() != null ? mailVo.getJpName() : "pj-contact", byteArrayResource);
            }
            return mimeMessage;
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }


    private SimpleMailMessage contructEmail(String subject, String body, Users users) {
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(users.getContacts().getEmail());
        email.setFrom(env.getProperty("support.email"));
        return email;
    }

    private MimeMessage constructHtmlEmail(String subject, String body, Users users) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setFrom(env.getProperty("support.email"));
            helper.setTo(users.getContacts().getEmail());
            helper.setSubject(subject);
            helper.setText(body, true);
            return mimeMessage;
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }
    private String[] buildParams(String... params) {
        return params;
    }

}
