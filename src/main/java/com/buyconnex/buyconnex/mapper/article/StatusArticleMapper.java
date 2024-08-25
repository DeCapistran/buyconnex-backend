package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.vo.article.StatusArticlesVo;

public class StatusArticleMapper {

	public static StatusArticlesVo toVO(StatusArticles statusArticles) {
		StatusArticlesVo statusArticlesVo = new StatusArticlesVo();
		statusArticlesVo.setId(statusArticles.getStatus_article_id());
		statusArticlesVo.setArticles(statusArticles.getArticles().stream().map(ArticleMapper::toVO).collect(Collectors.toSet()));
		statusArticlesVo.setDescription(statusArticles.getDescription());
		statusArticlesVo.setStatus(statusArticles.getStatus());
		
		return statusArticlesVo;
	}
	
	public static StatusArticles toEntity(StatusArticlesVo statusArticlesVo) {
		StatusArticles statusArticles = new StatusArticles();
		statusArticles.setStatus_article_id(statusArticlesVo.getId());
		statusArticles.setArticles(statusArticlesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		statusArticles.setDescription(statusArticlesVo.getDescription());
		statusArticles.setStatus(statusArticlesVo.getStatus());
		
		return statusArticles;
	}
	
	public static void updateEntityFromVO(StatusArticlesVo statusArticlesVo, StatusArticles statusArticles) {
		statusArticles.setStatus_article_id(statusArticlesVo.getId());
		statusArticles.setArticles(statusArticlesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		statusArticles.setDescription(statusArticlesVo.getDescription());
		statusArticles.setStatus(statusArticlesVo.getStatus());
	}
}
