package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.SousCategories;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

public class SousCategorieMapper {

	public static SousCategoriesVo toVO(SousCategories sousCategories) {
		SousCategoriesVo sousCategoriesVo = new SousCategoriesVo();
		sousCategoriesVo.setLibelle(sousCategories.getLibelle());
		sousCategoriesVo.setCategories(CategorieMapper.toVO(sousCategories.getCategories()));
		
		return sousCategoriesVo;
	}
	
	public static SousCategories toEntity(SousCategoriesVo sousCategoriesVo) {
		SousCategories sousCategories = new SousCategories();
		sousCategories.setLibelle(sousCategoriesVo.getLibelle());
		sousCategories.setCategories(CategorieMapper.toEntity(sousCategoriesVo.getCategories()));
		
		return sousCategories;
	}
	
	public static void updetEntityFromVO(SousCategoriesVo sousCategoriesVo, SousCategories sousCategories) {
		
		sousCategories.setLibelle(sousCategoriesVo.getLibelle());
		sousCategories.setCategories(CategorieMapper.toEntity(sousCategoriesVo.getCategories()));
		
	}
}
