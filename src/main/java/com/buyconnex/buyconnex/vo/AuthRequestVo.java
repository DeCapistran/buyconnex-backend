package com.buyconnex.buyconnex.vo;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AuthRequestVo {

    private String login;

    private String password;

    private List<String> roles;
}
