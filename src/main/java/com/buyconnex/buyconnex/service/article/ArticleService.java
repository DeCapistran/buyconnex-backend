package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.article.BoutiqueMapper;
import com.buyconnex.buyconnex.mapper.article.CategorieMapper;
import com.buyconnex.buyconnex.mapper.article.MarqueMapper;
import com.buyconnex.buyconnex.mapper.article.StatusArticleMapper;
import com.buyconnex.buyconnex.repository.article.ArticleRepository;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;
import com.buyconnex.buyconnex.vo.article.CategoriesVo;
import com.buyconnex.buyconnex.vo.article.MarquesVo;
import com.buyconnex.buyconnex.vo.article.StatusArticlesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArticleService implements IArticleService {

	@Autowired
	ArticleRepository articleRepository;
	
	@Override
	public Optional<ArticlesVo> findById(Long id) {
		return articleRepository.findById(id).map(ArticleMapper::toVO);
	}

	@Override
	public ArticlesVo saveArticle(ArticlesVo articlesVo) {
		Articles articles = ArticleMapper.toEntity(articlesVo);
		Articles articlesSave = articleRepository.save(articles);
		return ArticleMapper.toVO(articlesSave);
	}

	@Override
	public void deleteArticles(ArticlesVo articlesVo) {
		Articles articles = ArticleMapper.toEntity(articlesVo);
		articleRepository.delete(articles);
	}

	@Override
	public ArticlesVo updateArticles(Long id, ArticlesVo articlesVo) {
		return articleRepository.findById(id).map(article -> {
			ArticleMapper.updateEntityFromVO(articlesVo, article);
			Articles articlesUpdated = articleRepository.save(article);
			return ArticleMapper.toVO(articlesUpdated);
		}).orElse(null);
	}

	@Override
	public List<ArticlesVo> findByBoutique(BoutiquesVo boutiquesVo) {
		return articleRepository.findByBoutiques(BoutiqueMapper.toEntity(boutiquesVo)).stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesVo> findByCategories(CategoriesVo categoriesVo) {
		return articleRepository.findByCategories(CategorieMapper.toEntity(categoriesVo)).stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesVo> findByComposition(String composition) {
		return articleRepository.findByComposition(composition).stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesVo> findByMarques(MarquesVo marquesVo) {
		return articleRepository.findByMarques(MarqueMapper.toEntity(marquesVo)).stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesVo> findByPrix(Long prix) {
		return articleRepository.findByPrix(prix).stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesVo> findByQuantite(int quantite) {
		return articleRepository.findByQuantite(quantite).stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesVo> findByStatusArticles(StatusArticlesVo statusArticlesVo) {
		return articleRepository.findByStatusArticles(StatusArticleMapper.toEntity(statusArticlesVo)).stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesVo> findByTitle(String title) {
		return articleRepository.findByTitle(title).stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ArticlesVo> findAll() {
		return articleRepository.findAll().stream().map(ArticleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteArticlesById(Long id) {
		articleRepository.deleteById(id);
	}

}
