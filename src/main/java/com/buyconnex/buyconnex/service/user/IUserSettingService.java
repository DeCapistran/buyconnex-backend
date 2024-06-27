package com.buyconnex.buyconnex.service.user;

import java.util.Locale;

import com.buyconnex.buyconnex.entity.user.UserSettings;

public interface IUserSettingService {

    public UserSettings getUserSettingByUser(String login);

    public UserSettings getUserSettingByUserId(Long id);

    public void saveUserSettings(UserSettings userSettings);

    public Locale getLangueSettingByEmail(String email);

    public Locale getLangueSettingByUserSetting(UserSettings userSettings);


}
