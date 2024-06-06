package com.buyconnex.buyconnex.vo.other;

import java.util.Date;

import com.buyconnex.buyconnex.entity.user.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewslettersVo {

	private Date dateInscription;
	private Date desincription;
	private String email;
	private Users users;
}
