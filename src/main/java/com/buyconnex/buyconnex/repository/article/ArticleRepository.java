package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.entity.client.Paniers;






public interface ArticleRepository extends JpaRepository<Articles, Long> {

	List<Articles> findByBoutiques(Boutiques boutiques);
	List<Articles> findByCategories(Categories categories);
	List<Articles> findByCommandes(Commandes commandes);
	List<Articles> findByComposition(String composition);
	List<Articles> findByImages(Images images);
	List<Articles> findByPaniers(Paniers paniers);
	List<Articles> findByMarques(Marques marques);
	List<Articles> findByPrix(Long prix);
	List<Articles> findByPromotions(Promotions promotions);
	List<Articles> findByQuantite(int quantite);
	List<Articles> findByStatusArticles(StatusArticles statusArticles);
	List<Articles> findByTitle(String title);
}
