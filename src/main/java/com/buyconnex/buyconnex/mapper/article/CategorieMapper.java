package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;

public class CategorieMapper {

	public static CategoriesVo toVO(Categories categories) {
		CategoriesVo categoriesVo = new CategoriesVo();
		categoriesVo.setLibelle(categories.getLibelle());
		categoriesVo.setImg(categories.getImg());
		categoriesVo.setArticles(categories.getArticles());
		categoriesVo.setSousCategories(categories.getSousCategorie());
		categoriesVo.setImages(categories.getImages());
		
		return categoriesVo;
	}
	
	public static Categories toEntity(CategoriesVo categoriesVo) {
		Categories categories = new Categories();
		categories.setLibelle(categoriesVo.getLibelle());
		categories.setImg(categoriesVo.getImg());
		categories.setArticles(categoriesVo.getArticles());
		categories.setSousCategorie(categoriesVo.getSousCategories());
		categories.setImages(categoriesVo.getImages());
		
		return categories;
	}
	
	public static void updateEntityFromVO(CategoriesVo categoriesVo, Categories categories) {
		
		categories.setLibelle(categoriesVo.getLibelle());
		categories.setImg(categoriesVo.getImg());
		categories.setArticles(categoriesVo.getArticles());
		categories.setSousCategorie(categoriesVo.getSousCategories());
		categories.setImages(categoriesVo.getImages());
	}
}
