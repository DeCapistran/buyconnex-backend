package com.buyconnex.buyconnex.service.article;

import java.util.List;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.StatusArticles;

public interface IStatusArticle {

	public StatusArticles findById(Long id);
	public StatusArticles saveStatusArticles(StatusArticles articles);
	public void deleteStatusArticles(StatusArticles statusArticles);
	public StatusArticles updateStatusArticles(StatusArticles statusArticles);
	public List<StatusArticles> findByArticles(Articles articles);
	public List<StatusArticles> findByStatus(String status);
}
