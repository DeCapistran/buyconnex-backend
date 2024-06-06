package com.buyconnex.buyconnex.vo.user;

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
