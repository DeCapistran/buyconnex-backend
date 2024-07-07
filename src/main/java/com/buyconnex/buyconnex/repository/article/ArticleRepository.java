package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.entity.article.StatusArticles;


public interface ArticleRepository extends JpaRepository<Articles, Long> {

	List<Articles> findByBoutiques(Boutiques boutiques);
	List<Articles> findByCategories(Categories categories);
	List<Articles> findByComposition(String composition);
	List<Articles> findByMarques(Marques marques);
	List<Articles> findByPrix(Long prix);
	List<Articles> findByQuantite(int quantite);
	List<Articles> findByStatusArticles(StatusArticles statusArticles);
	List<Articles> findByTitle(String title);
	//boolean existByLibelle(String libelle);
}
