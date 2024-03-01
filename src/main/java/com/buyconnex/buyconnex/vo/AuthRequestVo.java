package com.buyconnex.buyconnex.vo;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestVo {

    private String username;

    String password;
}
