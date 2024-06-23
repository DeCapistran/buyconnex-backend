package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.article.StatusArticleMapper;
import com.buyconnex.buyconnex.repository.article.StatusArticleRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.StatusArticlesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusArticleService implements IStatusArticle {

	@Autowired
	StatusArticleRepository statusArticleRepository;
	
	@Override
	public Optional<StatusArticlesVo> findById(Long id) {
		return statusArticleRepository.findById(id).map(StatusArticleMapper::toVO);
	}

	@Override
	public StatusArticlesVo saveStatusArticles(StatusArticlesVo statusArticlesVo) {
		StatusArticles statusArticles = StatusArticleMapper.toEntity(statusArticlesVo);
		StatusArticles statusArticlesSave = statusArticleRepository.save(statusArticles);
		return StatusArticleMapper.toVO(statusArticlesSave);
	}

	@Override
	public void deleteStatusArticles(StatusArticlesVo statusArticlesVo) {
		StatusArticles statusArticles = StatusArticleMapper.toEntity(statusArticlesVo);
		statusArticleRepository.delete(statusArticles);
	}

	@Override
	public StatusArticlesVo updateStatusArticles(Long id, StatusArticlesVo statusArticlesVo) {
		return statusArticleRepository.findById(id).map(statusArticle -> {
			StatusArticleMapper.updateEntityFromVO(statusArticlesVo, statusArticle);
			StatusArticles statusArticlesUpdated = statusArticleRepository.save(statusArticle);
			return StatusArticleMapper.toVO(statusArticlesUpdated);
		}).orElse(null);
	}

	@Override
	public List<StatusArticlesVo> findByArticles(ArticlesVo articlesVo) {
		return statusArticleRepository.findByArticles(ArticleMapper.toEntity(articlesVo)).stream().map(StatusArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<StatusArticlesVo> findByStatus(String status) {
		return statusArticleRepository.findByStatus(status).stream().map(StatusArticleMapper::toVO).collect(Collectors.toList());
	}

}
