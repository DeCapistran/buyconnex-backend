package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.ArticlesImages;
import com.buyconnex.buyconnex.entity.article.Images;


public interface ArticleImageRepository extends JpaRepository<ArticlesImages, Long>{

	List<ArticlesImages> findByArticles (Articles articles);
	List<ArticlesImages> findByImages(Images images);
}
