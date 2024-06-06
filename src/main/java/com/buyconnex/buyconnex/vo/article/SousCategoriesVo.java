package com.buyconnex.buyconnex.vo.article;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.entity.article.Categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SousCategoriesVo {

	private String libelle;
	private Categories categories;
	private Coupons coupons;
}
