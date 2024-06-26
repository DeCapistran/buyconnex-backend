package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;

public class CategorieMapper {

	public static CategoriesVo toVO(Categories categories) {
		CategoriesVo categoriesVo = new CategoriesVo();
		categoriesVo.setLibelle(categories.getLibelle());
		categoriesVo.setImg(categories.getImg());
		categoriesVo.setArticles(categories.getArticles().stream().map(ArticleMapper::toVO).collect(Collectors.toSet()));
		categoriesVo.setSousCategories(categories.getSousCategorie().stream().map(SousCategorieMapper::toVO).collect(Collectors.toSet()));
		categoriesVo.setImages(ImageMapper.toVO(categories.getImages()));
		
		return categoriesVo;
	}
	
	public static Categories toEntity(CategoriesVo categoriesVo) {
		Categories categories = new Categories();
		categories.setLibelle(categoriesVo.getLibelle());
		categories.setImg(categoriesVo.getImg());
		categories.setArticles(categoriesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		categories.setSousCategorie(categoriesVo.getSousCategories().stream().map(SousCategorieMapper::toEntity).collect(Collectors.toSet()));
		categories.setImages(ImageMapper.toEntity(categoriesVo.getImages()));
		
		return categories;
	}
	
	public static void updateEntityFromVO(CategoriesVo categoriesVo, Categories categories) {
		
		categories.setLibelle(categoriesVo.getLibelle());
		categories.setImg(categoriesVo.getImg());
		categories.setArticles(categoriesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		categories.setSousCategorie(categoriesVo.getSousCategories().stream().map(SousCategorieMapper::toEntity).collect(Collectors.toSet()));
		categories.setImages(ImageMapper.toEntity(categoriesVo.getImages()));
	}
}
