package com.buyconnex.buyconnex.batch;

import com.buyconnex.buyconnex.service.user.IUserService;
import com.buyconnex.buyconnex.service.util.IMailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class UserManagerBatch {

    private static final Logger logger = LoggerFactory.getLogger(UserManagerBatch.class);

    private IUserService userService;

    private JavaMailSender mailSender;

    private IMailService mailService;




}
