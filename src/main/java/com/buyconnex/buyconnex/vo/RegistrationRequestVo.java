package com.buyconnex.buyconnex.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class RegistrationRequestVo {

	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String email;
}
