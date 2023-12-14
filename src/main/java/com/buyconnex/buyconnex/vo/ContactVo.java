package com.buyconnex.buyconnex.vo;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ContactVo {

    private Long idContact;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String telephone;

    private boolean isActivated = true;

    private boolean isLocked = false;

    private List<String> roles;
}
