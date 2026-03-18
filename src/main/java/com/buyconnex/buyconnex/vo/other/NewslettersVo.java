package com.buyconnex.buyconnex.vo.other;

import java.time.LocalDateTime;

import com.buyconnex.buyconnex.vo.user.UsersVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewslettersVo {
	private Long id;
	private LocalDateTime dateInscription;
	private LocalDateTime dateDesincription;
	private String email;
	private UsersVo users;
}
