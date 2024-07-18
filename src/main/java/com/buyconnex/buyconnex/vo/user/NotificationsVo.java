package com.buyconnex.buyconnex.vo.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationsVo {
	private Long id;
	private String libelle;
	private String description;
	private String status;
	private LocalDateTime dateNotif;
	private UsersVo users;
}
