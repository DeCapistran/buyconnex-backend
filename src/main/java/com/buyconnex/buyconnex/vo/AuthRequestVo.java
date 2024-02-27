package com.buyconnex.buyconnex.vo;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestVo {

    private String email;

    String password;
}
