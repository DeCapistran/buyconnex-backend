package com.buyconnex.buyconnex.service.user;

import java.util.Locale;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.user.UserSettings;
import com.buyconnex.buyconnex.repository.user.UserSettingsRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSettingService implements IUserSettingService {

    @NonNull
    private UserSettingsRepository userSettingsRepository;

    @Override
    public UserSettings getUserSettingByUser(String login) {
        return userSettingsRepository.getUserSettingByLogin(login);
    }

    @Override
    public UserSettings getUserSettingByUserId(Long id) {
        return userSettingsRepository.getUserSettingByUserId(id);
    }

    @Override
    public void saveUserSettings(UserSettings userSettings) {
        userSettingsRepository.save(userSettings);
    }

    @Override
    public Locale getLangueSettingByEmail(String email) {
        UserSettings userSettings = userSettingsRepository.getUserSettingByEmail(email);
        return getLangueSettingByUserSetting(userSettings);
    }

    @Override
    public Locale getLangueSettingByUserSetting(UserSettings userSettings) {
        if (userSettings != null && userSettings.getLangue() != null) {
            return userSettings.getLangue().contains("FR") ? Locale.FRANCE : Locale.US;
        }
        return Locale.FRANCE;
    }
}
