package com.buyconnex.buyconnex.vo;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponseVo {

	private String token;
    private String username;
}
