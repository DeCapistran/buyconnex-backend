package com.buyconnex.buyconnex.vo.article;

import java.util.Set;

import com.buyconnex.buyconnex.vo.achat.CouponsVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SousCategoriesVo {
	private Long id;
	private String libelle;
	private CategoriesVo categories;
	private Set<CouponsVo> coupons;
}
