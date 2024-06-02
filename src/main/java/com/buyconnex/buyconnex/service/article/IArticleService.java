package com.buyconnex.buyconnex.service.article;

import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.entity.client.Paniers;

public interface IArticleService {

	public Articles findById(Long id);
	public Articles saveArticle(Articles articles);
	public void deleteArticles(Articles articles);
	public Articles updateArticles(Articles articles);
	public List<Articles> findByBoutique(Boutiques boutiques);
	public List<Articles> findByCategories(Categories categories);
	public List<Articles> findByCommandes(Commandes commandes);
	public List<Articles> findByComposition(String composition);
	public List<Articles> findByImages(Images images);
	public List<Articles> findByPaniers(Paniers paniers);
	public List<Articles> findByMarques(Marques marques);
	public List<Articles> findByPrix(Long prix);
	public List<Articles> findByPromotions(Promotions promotions);
	public List<Articles> findByQuantite(int quantite);
	public List<Articles> findByStatusArticles(StatusArticles statusArticles);
	public List<Articles> findByTitle(String title);
	
}
