package com.buyconnex.buyconnex.service.setting;

import com.buyconnex.buyconnex.entity.utils.Settings;
import com.buyconnex.buyconnex.vo.user.SettingAppVo;

public interface ISettingService extends ISettingParams {

    public SettingAppVo getSettingApp();

    public Settings getSettingById(Long id);

    public Settings getLogoSte();

    public Settings getLogoLogin();

    public Settings getFavicon();

    public Settings getUrlApp();

    public Settings getEmailCreationCorpsCount();

    public Settings getEmailCreationObjectCount();

    public Settings getEmailContact();
}
