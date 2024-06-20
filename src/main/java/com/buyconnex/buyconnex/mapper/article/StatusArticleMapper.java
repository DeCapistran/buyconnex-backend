package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.vo.article.StatusArticlesVo;

public class StatusArticleMapper {

	public static StatusArticlesVo toVO(StatusArticles statusArticles) {
		StatusArticlesVo statusArticlesVo = new StatusArticlesVo();
		statusArticlesVo.setArticles(statusArticles.getArticles());
		statusArticlesVo.setDescription(statusArticles.getDescription());
		statusArticlesVo.setStatus(statusArticles.getStatus());
		
		return statusArticlesVo;
	}
	
	public static StatusArticles toEntity(StatusArticlesVo statusArticlesVo) {
		StatusArticles statusArticles = new StatusArticles();
		statusArticles.setArticles(statusArticlesVo.getArticles());
		statusArticles.setDescription(statusArticlesVo.getDescription());
		statusArticles.setStatus(statusArticlesVo.getStatus());
		
		return statusArticles;
	}
}
