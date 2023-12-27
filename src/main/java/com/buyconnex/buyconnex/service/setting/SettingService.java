package com.buyconnex.buyconnex.service.setting;

import com.buyconnex.buyconnex.entity.utils.Settings;
import com.buyconnex.buyconnex.repository.utils.SettingRepository;
import com.buyconnex.buyconnex.vo.SettingAppVo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingService implements ISettingService {

    @NonNull
    private SettingRepository settingRepository;

    @Override
    public SettingAppVo getSettingApp() {
        SettingAppVo settingAppVo = new SettingAppVo();

        settingAppVo.setDefaultLang(getDefaultLang());
        settingAppVo.setDefaultLang(getFooter());
        settingAppVo.setDefaultLang(getCouleur().toLowerCase());
        settingAppVo.setDefaultLang(getThemeMenu().toLowerCase());
        settingAppVo.setDefaultLang(getThemeBarreSup().toLowerCase());
        settingAppVo.setDefaultLang(getStyleSaisie().toLowerCase());
        settingAppVo.setDefaultLang(getTypeMenu().toLowerCase());
        settingAppVo.setDefaultLang(getWelcomeMsg());

        return settingAppVo;
    }

    @Override
    public Settings getSettingById(Long id) {
        return settingRepository.getSettingById(id);
    }

    public Settings getLogoSte() {
        return settingRepository.getSettingById(SETTING_LOGO_BLOB);
    }

    public Settings getLogoLogin() {
        return settingRepository.getSettingById(SETTING_LOGO_LOGIN_BLOB);
    }

    public Settings getFavicon() {
        return settingRepository.getSettingById(SETTING_FAVICON_BLOB);
    }

    @Override
    public Settings getUrlApp() {
        return settingRepository.getSettingById(SETTING_URL_STR);
    }

    @Override
    public Settings getEmailCreationCorpsCount() {
        return settingRepository.getSettingById(SETTING_MAIL_CREATION_COMPTE_CLOB);
    }

    @Override
    public Settings getEmailCreationObjectCount() {
        return settingRepository.getSettingById(SETTING_MAIL_CREATION_COMPTE_OBJECT_STR);
    }

    @Override
    public Settings getEmailContact() {
        return settingRepository.getSettingById(SETTING_MAIL_CONTACT);
    }

    private String getDefaultLang() {
        Settings settings = settingRepository.getSettingById(SETTING_DEFAULT_LANG);
        if (settings.getValueLong() != null && settings.getValueLong().toString().equals(FR_ID)) {
            return "fr-FR";
        }
        return "en-US";
    }

    private String getFooter() {
        Settings settings = settingRepository.getSettingById(SETTING_FOOTER);
        return settings.getValueStr() != null && !settings.getValueStr().isEmpty() ? settings.getValueStr() : settings.getDefaultValueStr();
    }

    private String getCouleur() {
        Settings settings = settingRepository.getSettingById(SETTING_COULEUR);
        return settings.getValueStr() != null && !settings.getValueStr().isEmpty() ? settings.getValueStr() : settings.getDefaultValueStr();
    }

    private String getThemeMenu() {
        Settings settings = settingRepository.getSettingById(SETTING_THEME_MENU);
        return settings.getValueStr() != null && !settings.getValueStr().isEmpty() ? settings.getValueStr() : settings.getDefaultValueStr();
    }

    private String getThemeBarreSup() {
        Settings settings = settingRepository.getSettingById(SETTING_THEME_BARRE_SUP);
        return settings.getValueStr() != null && !settings.getValueStr().isEmpty() ? settings.getValueStr() : settings.getDefaultValueStr();
    }

    private String getStyleSaisie() {
        Settings settings = settingRepository.getSettingById(SETTING_STYLE_SAISIE);
        return settings.getValueStr() != null && !settings.getValueStr().isEmpty() ? settings.getValueStr() : settings.getDefaultValueStr();
    }

    private String getTypeMenu() {
        Settings settings = settingRepository.getSettingById(SETTING_MENU_TYPE);
        return settings.getValueStr() != null && !settings.getValueStr().isEmpty() ? settings.getValueStr() : settings.getDefaultValueStr();
    }

    private String getWelcomeMsg() {
        Settings settings = settingRepository.getSettingById(SETTING_WELCOME_MSG);
        return settings.getValueStr() != null && !settings.getValueStr().isEmpty() ? settings.getValueStr() : settings.getDefaultValueStr();
    }

}
