package com.buyconnex.buyconnex.batch;

import com.buyconnex.buyconnex.entity.user.UserSettings;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.entity.utils.Settings;
import com.buyconnex.buyconnex.service.user.IUserService;
import com.buyconnex.buyconnex.service.user.IUserSettingService;
import com.buyconnex.buyconnex.service.utils.IMailService;
import com.buyconnex.buyconnex.utils.MiscUtils;
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
import java.util.Locale;
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
    private MiscUtils miscUtils;

    @NonNull
    private ISettingService getLangueSettingByEmail;

    @NonNull
    private IUserSettingService userSettingService;

    @Scheduled(cron = "${create.users.cron.expression}")
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
            Settings settings = getLangueSettingByEmail.getSettingById(ISettingService.SETTING_DEFAULT_LANG);
            logger.info("Create User");
            UserSettings userSettings = new UserSettings();
            userSettings.setUsers(user);
            userSettings.setLangue(settings.getValueLong() != null && settings.getValueLong().toString().equals(ISettingService.FR_ID) ? "fr-FR" : "en-US");
            userSettings.setNotifActive(true);
            userSettings.setMfaActive(false);
            userSettingService.saveUserSettings(userSettings);
            logger.info("Create Setting User");
            mailSender.send(mailService.constructCreateAccountTokenEmail(miscUtils.getUrlApp(),
            		(settings.getValueLong() != null && settings.getValueLong().toString().equals(ISettingService.FR_ID)) ? Locale.FRENCH : Locale.ENGLISH, token, user));
            logger.info("User created");

        }
    }

    @Scheduled(cron = "${create.users.cron.expression}")
    public void updateUser() {
    	List<Users> users = userService.findUserToUpdate();
    	for(Users user : users) {
    		logger.info("Update users [Old login : {}][New login : {}]", user.getContacts().getEmail());
    		user.setLogin(user.getContacts().getEmail());
    		userService.saveUser(user);
    		logger.info("User updated");
    	}
    }

}
