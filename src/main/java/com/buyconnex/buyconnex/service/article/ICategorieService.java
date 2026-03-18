package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;

public interface ICategorieService {

	public Optional<CategoriesVo> findById(Long id);
	public List<CategoriesVo> findAll();
	public CategoriesVo saveCategorie(CategoriesVo categoriesVo);
	public void deleteCategorie(CategoriesVo categoriesVo);
	public void deleteCategorieById(Long id);
	public CategoriesVo updateCategorie(Long id, CategoriesVo categoriesVo);
	public List<CategoriesVo> findByArticles(ArticlesVo articlesVo);
	public List<CategoriesVo> findByImages(ImagesVo imagesVo);
	public List<CategoriesVo> findByLibelle(String libelle);
	public boolean existsByLibelleCategorie(String libelle);
	public boolean existsByLibelleCategorieAndNotId(String libelle, Long id);
}
