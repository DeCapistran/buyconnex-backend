package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.repository.article.ArticleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArticleService implements IArticleService {

	@Autowired
	ArticleRepository articleRepository;
	
	@Override
	public Optional<Articles> findById(Long id) {
		return articleRepository.findById(id);
	}

	@Override
	public Articles saveArticle(Articles articles) {
		return articleRepository.save(articles);
	}

	@Override
	public void deleteArticles(Articles articles) {
		articleRepository.delete(articles);
	}

	@Override
	public Articles updateArticles(Articles articles) {
		return articleRepository.save(articles);
	}

	@Override
	public List<Articles> findByBoutique(Boutiques boutiques) {
		return articleRepository.findByBoutiques(boutiques);
	}

	@Override
	public List<Articles> findByCategories(Categories categories) {
		return articleRepository.findByCategories(categories);
	}

	@Override
	public List<Articles> findByCommandes(Commandes commandes) {
		return articleRepository.findByCommandes(commandes);
	}

	@Override
	public List<Articles> findByComposition(String composition) {
		return articleRepository.findByComposition(composition);
	}

	@Override
	public List<Articles> findByImages(Images images) {
		return articleRepository.findByImages(images);
	}

	@Override
	public List<Articles> findByPaniers(Paniers paniers) {
		return articleRepository.findByPaniers(paniers);
	}

	@Override
	public List<Articles> findByMarques(Marques marques) {
		return articleRepository.findByMarques(marques);
	}

	@Override
	public List<Articles> findByPrix(Long prix) {
		return articleRepository.findByPrix(prix);
	}

	@Override
	public List<Articles> findByPromotions(Promotions promotions) {
		return articleRepository.findByPromotions(promotions);
	}

	@Override
	public List<Articles> findByQuantite(int quantite) {
		return articleRepository.findByQuantite(quantite);
	}

	@Override
	public List<Articles> findByStatusArticles(StatusArticles statusArticles) {
		return articleRepository.findByStatusArticles(statusArticles);
	}

	@Override
	public List<Articles> findByTitle(String title) {
		return articleRepository.findByTitle(title);
	}

}
