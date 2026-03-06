package com.buyconnex.buyconnex.mapper.article;


import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.vo.article.StatusArticlesVo;

public class StatusArticleMapper {

	public static StatusArticlesVo toVO(StatusArticles statusArticles) {
		if(statusArticles == null) return null;
		StatusArticlesVo statusArticlesVo = new StatusArticlesVo();
		statusArticlesVo.setId(statusArticles.getStatus_article_id());
		statusArticlesVo.setDescription(statusArticles.getDescription());
		statusArticlesVo.setStatus(statusArticles.getStatus());
		
		return statusArticlesVo;
	}
	
	public static StatusArticles toEntity(StatusArticlesVo statusArticlesVo) {
		if(statusArticlesVo == null) return null;
		StatusArticles statusArticles = new StatusArticles();
		statusArticles.setStatus_article_id(statusArticlesVo.getId());
		statusArticles.setDescription(statusArticlesVo.getDescription());
		statusArticles.setStatus(statusArticlesVo.getStatus());
		
		return statusArticles;
	}
	
	public static void updateEntityFromVO(StatusArticlesVo statusArticlesVo, StatusArticles statusArticles) {
		statusArticles.setStatus_article_id(statusArticlesVo.getId());
		statusArticles.setDescription(statusArticlesVo.getDescription());
		statusArticles.setStatus(statusArticlesVo.getStatus());
	}
}
