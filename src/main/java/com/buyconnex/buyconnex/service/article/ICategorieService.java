package com.buyconnex.buyconnex.service.article;

import java.util.List;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.SousCategories;

public interface ICategorieService {

	public Categories findById(Long id);
	public Categories saveCategorie(Categories categories);
	public void deleteCategorie(Categories categories);
	public Categories updateCategorie(Categories categories);
	public List<Categories> findByArticles(Articles articles);
	public List<Categories> findByImages(Images images);
	public List<Categories> findByLibelle(String libelle);
	public List<Categories> findSousCategories(SousCategories sousCategories);
}
