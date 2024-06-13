package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Tags;

public interface ITagService {

	public Optional<Tags> findById(Long id);
	public Tags saveTags(Tags tags);
	public void deleteTags(Tags tags);
	public Tags updateTags(Tags tags);
	public List<Tags> findByArticles(Articles articles);
	public List<Tags> findByNom(String nom);
}
