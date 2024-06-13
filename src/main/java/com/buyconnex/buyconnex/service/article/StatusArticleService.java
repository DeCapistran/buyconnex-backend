package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.repository.article.StatusArticleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusArticleService implements IStatusArticle {

	@Autowired
	StatusArticleRepository statusArticleRepository;
	
	@Override
	public Optional<StatusArticles> findById(Long id) {
		return statusArticleRepository.findById(id);
	}

	@Override
	public StatusArticles saveStatusArticles(StatusArticles statusArticles) {
		return statusArticleRepository.save(statusArticles);
	}

	@Override
	public void deleteStatusArticles(StatusArticles statusArticles) {
		statusArticleRepository.delete(statusArticles);
	}

	@Override
	public StatusArticles updateStatusArticles(StatusArticles statusArticles) {
		return statusArticleRepository.save(statusArticles);
	}

	@Override
	public List<StatusArticles> findByArticles(Articles articles) {
		return statusArticleRepository.findByArticles(articles);
	}

	@Override
	public List<StatusArticles> findByStatus(String status) {
		return statusArticleRepository.findByStatus(status);
	}

}
