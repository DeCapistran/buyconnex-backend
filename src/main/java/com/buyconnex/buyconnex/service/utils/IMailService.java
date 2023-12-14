package com.buyconnex.buyconnex.service.utils;

import com.buyconnex.buyconnex.entity.user.Users;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ws.mime.MimeMessage;

import java.util.Locale;

public interface IMailService {

    public SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale, final String token, final Users users);

    public SimpleMailMessage constructOtpConnectEmail(final Locale locale, String codeOtp, final Users users);

    public MimeMessage constructCreateAccountTokenEmail(final String contextPath, final Locale locale, final String token, final Users users);

    //public MimeMessage constructEmailContact();
}
