package com.buyconnex.buyconnex.vo.user;

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
public class NotificationsVo {

	private String libelle;
	private String description;
	private String status;
	private Date dateNotif;
	private Users users;
}
