package com.buyconnex.buyconnex.vo;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AuthResponseVo {

    private String currentLogin;

    private String accesToken;

    private String tokenType;

    private boolean isLocked;

    private String userEmail;

    private List<String> roles;

    private UserSettingVo userSettingVo;
}
