package com.buyconnex.buyconnex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImgVo {

    private String name;

    private String type;

    private byte[] logoSte;

    private byte[] logoLogin;

    private byte[] fiveIcon;

    private byte[] profilImg;
}
