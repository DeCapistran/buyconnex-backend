package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.StatusArticlesVo;

public interface IStatusArticle {

	public Optional<StatusArticlesVo> findById(Long id);
	public List<StatusArticlesVo> findAll();
	public StatusArticlesVo saveStatusArticles(StatusArticlesVo articlesVo);
	public void deleteStatusArticles(StatusArticlesVo statusArticlesVo);
	public void deleteStatusArticlesById(Long id);
	public StatusArticlesVo updateStatusArticles(Long id, StatusArticlesVo statusArticlesVo);
	public List<StatusArticlesVo> findByArticles(ArticlesVo articlesVo);
	public List<StatusArticlesVo> findByStatus(String status);
}
