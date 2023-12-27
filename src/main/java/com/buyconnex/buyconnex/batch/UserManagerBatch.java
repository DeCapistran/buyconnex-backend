package com.buyconnex.buyconnex.batch;

import com.buyconnex.buyconnex.entity.user.UserSettings;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.service.user.IUserService;
import com.buyconnex.buyconnex.service.user.IUserSettingService;
import com.buyconnex.buyconnex.service.utils.IMailService;
import com.buyconnex.buyconnex.service.setting.ISettingService;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class UserManagerBatch {

    private static final Logger logger = LoggerFactory.getLogger(UserManagerBatch.class);

    @NonNull
    private IUserService userService;

    @NonNull
    private JavaMailSender mailSender;

    @NonNull
    private IMailService mailService;

    @NonNull
    private ISettingService getLangueSettingByEmail;

    @NonNull
    private IUserSettingService userSettingService;

    @Scheduled(cron = "${create.user.cron.expression}")
    public void createUser() {

        Date now = Date.from(Instant.now());
        String token = UUID.randomUUID().toString();
        List<Users> users = userService.findUserToCreate();

        for (Users user : users) {
            user.setBActivated(true);
            user.setDateCreation(now);
            user.setBLocked(false);
            userService.saveUser(user);
            userService.createResetPasswordTokenForUser(user, token);
            //Settings settings = getLangueSettingByEmail.get
            UserSettings userSettings = new UserSettings();
            userSettings.setUsers(user);
            //userSettings.setLangue();
            userSettings.setNotifActive(true);
            userSettings.setMfaActive(false);
            userSettingService.saveUserSettings(userSettings);
            logger.info("Create Setting User");
            //mailSender.send(mailService.constructCreateAccountTokenEmail());
            logger.info("User created");

        }
    }


}
