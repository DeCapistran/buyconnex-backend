package com.buyconnex.buyconnex.vo.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPasswordVo {

    private String oldPassword;

    private String newPassword;
    
    private String login;

}
