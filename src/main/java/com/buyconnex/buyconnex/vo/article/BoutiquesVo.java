package com.buyconnex.buyconnex.vo.article;

import com.buyconnex.buyconnex.entity.article.Articles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoutiquesVo {

	private String nom;
	private String email;
	private String telephone;
	private String img;
	private Articles articles;
}
