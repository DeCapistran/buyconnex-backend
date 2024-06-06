package com.buyconnex.buyconnex.vo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSettingVo {

    private String langue;

    private boolean mfaActive;

    private boolean notifActive;

    public void setDefaultLangue() {
        setLangue("fr-FR");
    }

    public String getDefaultLangue() {
        return "fr-FR";
    }
}
