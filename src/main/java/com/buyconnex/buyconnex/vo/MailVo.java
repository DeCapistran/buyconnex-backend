package com.buyconnex.buyconnex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailVo {

    private String sujet;

    private String message;

    private byte[] pj;

    private String jpName;
}
