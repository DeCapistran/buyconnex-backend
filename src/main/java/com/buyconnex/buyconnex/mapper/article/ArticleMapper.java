package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

public class ArticleMapper {

	public static ArticlesVo toVO(Articles articles) {
		ArticlesVo articlesVo = new ArticlesVo();
		articlesVo.setSku(articles.getSku());
		articlesVo.setImgPath(articles.getImgPath());
		articlesVo.setTitle(articles.getTitle());
		articlesVo.setPrix(articles.getPrix());
		articlesVo.setQuantite(articles.getQuantite());
		articlesVo.setDescription(articles.getDescription());
		articlesVo.setComposition(articles.getComposition());
		articlesVo.setDateAjout(articles.getDateAjout());
		articlesVo.setCategories(articles.getCategories());
		articlesVo.setMarques(articles.getMarques());
		articlesVo.setBoutiques(articles.getBoutiques());
		articlesVo.setStatusArticles(articles.getStatusArticles());
		articlesVo.setPromotions(articles.getPromotions());
		articlesVo.setTags(articles.getTags());
		articlesVo.setCommandes(articles.getCommandes());
		articlesVo.setPaniers(articles.getPaniers());
		articlesVo.setAvis(articles.getAvis());
		articlesVo.setImages(articles.getImages());
		
		return articlesVo;
	}
	
	public static Articles toEntity(ArticlesVo articlesVo) {
		Articles articles = new Articles();
		articles.setSku(articlesVo.getSku());
		articles.setImgPath(articlesVo.getImgPath());
		articles.setTitle(articlesVo.getTitle());
		articles.setPrix(articlesVo.getPrix());
		articles.setQuantite(articlesVo.getQuantite());
		articles.setDescription(articlesVo.getDescription());
		articles.setComposition(articlesVo.getComposition());
		articles.setDateAjout(articlesVo.getDateAjout());
		articles.setCategories(articlesVo.getCategories());
		articles.setMarques(articlesVo.getMarques());
		articles.setBoutiques(articlesVo.getBoutiques());
		articles.setStatusArticles(articlesVo.getStatusArticles());
		articles.setPromotions(articlesVo.getPromotions());
		articles.setTags(articlesVo.getTags());
		articles.setCommandes(articlesVo.getCommandes());
		articles.setPaniers(articlesVo.getPaniers());
		articles.setAvis(articlesVo.getAvis());
		articles.setImages(articlesVo.getImages());
		
		return articles;
	}
}
