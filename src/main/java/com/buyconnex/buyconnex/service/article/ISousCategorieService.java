package com.buyconnex.buyconnex.service.article;

import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.SousCategories;

public interface ISousCategorieService {

	public SousCategories findById(Long id);
	public SousCategories saveSousCategorie(SousCategories sousCategories);
	public void deleteSousCategorie(SousCategories sousCategories);
	public SousCategories updateSousCategorie(SousCategories sousCategories);
	public List<SousCategories> findByCategories(Categories categories);
	public List<SousCategories> findByCoupons(Coupons coupons);
	public List<SousCategories> findByLibelle(String libelle);
}
