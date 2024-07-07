package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Tags;
import com.buyconnex.buyconnex.entity.article.TagsArticles;

public interface TagArticleRepository extends JpaRepository<TagsArticles, Long> {

	List<TagsArticles> findByArticles (Articles articles);
	List<TagsArticles> findByTags(Tags tags);
}
