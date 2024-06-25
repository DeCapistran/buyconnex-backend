package com.buyconnex.buyconnex.vo.article;

import java.time.LocalDateTime;

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
public class AvisVo {
	private Long id;
	private LocalDateTime dateAvis;
	private int etoile;
	private String commentaire;
	private Articles articles;
	private Users users;
}
