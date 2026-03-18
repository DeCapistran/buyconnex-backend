package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.StatusArticles;


public interface StatusArticleRepository extends JpaRepository<StatusArticles, Long> {

	List<StatusArticles> findByArticles(Articles articles);
	List<StatusArticles> findByStatus(String status);
}
