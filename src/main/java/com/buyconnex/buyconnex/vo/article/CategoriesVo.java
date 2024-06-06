package com.buyconnex.buyconnex.vo.article;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.SousCategories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesVo {

	private String libelle;
	private String img;
	private Articles articles;
	private SousCategories sousCategories;
	private Images images;
}
