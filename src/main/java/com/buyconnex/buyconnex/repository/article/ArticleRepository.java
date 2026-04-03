package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.entity.article.StatusArticles;
import com.buyconnex.buyconnex.entity.article.Tags;


public interface ArticleRepository extends JpaRepository<Articles, Long> {

	List<Articles> findByBoutiques(Boutiques boutiques);
	List<Articles> findByTags(Tags tags);
	List<Articles> findByCategories(Categories categories);
	List<Articles> findByComposition(String composition);
	List<Articles> findByMarques(Marques marques);
	List<Articles> findByPrix(Long prix);
	List<Articles> findByQuantite(int quantite);
	List<Articles> findByStatusArticles(StatusArticles statusArticles);
	List<Articles> findByTitle(String title);
	List<Articles> findByImages(Images images);

	@Query("SELECT COUNT(a) > 0 FROM Articles a WHERE LOWER(a.title) = LOWER(:title) AND a.article_id != :id")
    boolean existsByLibelleArticleAndNotId(@Param("title") String title, @Param("id") Long id);
	
	@Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Articles a WHERE LOWER(a.title) = LOWER(:title)")
	boolean existsByLibelleArticleIgnoreCase(@Param("title") String title);

	@Query("SELECT pd.articles FROM PromotionsDetails pd WHERE pd.promotions.promotion_id = :promotionId")
	List<Articles> findByPromotionId(@Param("promotionId") Long promotionId);
}
