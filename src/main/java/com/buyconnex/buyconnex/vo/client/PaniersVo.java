package com.buyconnex.buyconnex.vo.client;

import java.time.LocalDateTime;
import java.util.Set;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

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
	private UsersVo users;
	private Set<ArticlesVo> articles;
}
