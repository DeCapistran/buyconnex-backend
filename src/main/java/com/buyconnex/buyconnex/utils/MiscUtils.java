package com.buyconnex.buyconnex.utils;

import com.buyconnex.buyconnex.service.setting.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiscUtils {

    @Autowired
    private ISettingService iSettingService;

    public String getUrlApp() {
        return iSettingService.getUrlApp().getValueStr();
    }
}
