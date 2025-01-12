package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;



public interface CategorieRepository extends JpaRepository<Categories, Long> {

	List<Categories> findByArticles(Articles articles);
	List<Categories> findByImages(Images images);
	List<Categories> findByLibelle(String libelle);
	
	@Query("SELECT COUNT(c) > 0 FROM Categories c WHERE LOWER(c.libelle) = LOWER(:libelle) AND c.categorie_id != :id")
    boolean existsByLibelleCategorieAndNotId(@Param("libelle") String libelle, @Param("id") Long id);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Categories c WHERE LOWER(c.libelle) = LOWER(:libelle)")
	boolean existsByLibelleCategorieIgnoreCase(@Param("libelle") String libelle);
}
