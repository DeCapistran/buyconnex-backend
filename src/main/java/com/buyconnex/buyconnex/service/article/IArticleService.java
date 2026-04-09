package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.ArticlesImagesVo;
import com.buyconnex.buyconnex.vo.article.ImagesVo;
import com.buyconnex.buyconnex.vo.article.MarquesVo;
import com.buyconnex.buyconnex.vo.article.StatusArticlesVo;

public interface IArticleService {

	public Optional<ArticlesVo> findById(Long id);
	public List<ArticlesVo> findAll();
	public ArticlesVo saveArticle(ArticlesVo articlesVo);
	public void deleteArticles(ArticlesVo articlesVo);
	public void deleteArticlesById(Long id);
	public ArticlesVo updateArticles(Long id, ArticlesVo articlesVo);
	public List<ArticlesVo> findByBoutique(BoutiquesVo boutiquesVo);
	public List<ArticlesVo> findByCategories(CategoriesVo categoriesVo);
	public List<ArticlesVo> findByComposition(String composition);
	public List<ArticlesVo> findByMarques(MarquesVo marquesVo);
	public List<ArticlesVo> findByPrix(Long prix);
	public List<ArticlesVo> findByQuantite(int quantite);
	public List<ArticlesVo> findByStatusArticles(StatusArticlesVo statusArticlesVo);
	public List<ArticlesVo> findByTitle(String title);
	List<ArticlesVo> findByImages(ImagesVo imagesVo);
	Optional<List<ArticlesImagesVo>> getImagesByArticleId(Long articleId);
	public boolean existsByLibelleArticle(String title);
	public boolean existsByLibelleArticleAndNotId(String title, Long id);
	public List<ArticlesVo> findByPromotionId(Long promotionId);
	
}
