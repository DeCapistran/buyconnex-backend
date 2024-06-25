package com.buyconnex.buyconnex.vo.client;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.user.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaniersVo {
	private Long id;
	private LocalDateTime datePanier;
	private Users users;
	private Set<Articles> articles;
}
