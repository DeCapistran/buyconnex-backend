package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.article.SousCategoriesVo;

public interface ICategorieService {

	public Optional<CategoriesVo> findById(Long id);
	public CategoriesVo saveCategorie(CategoriesVo categoriesVo);
	public void deleteCategorie(CategoriesVo categoriesVo);
	public CategoriesVo updateCategorie(Long id, CategoriesVo categoriesVo);
	public List<CategoriesVo> findByArticles(ArticlesVo articlesVo);
	public List<CategoriesVo> findByImages(ImagesVo imagesVo);
	public List<CategoriesVo> findByLibelle(String libelle);
	public List<CategoriesVo> findBySousCategories(SousCategoriesVo sousCategoriesVo);
}
