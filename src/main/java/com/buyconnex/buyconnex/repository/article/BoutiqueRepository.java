package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Images;


public interface BoutiqueRepository extends JpaRepository<Boutiques, Long> {

	List<Boutiques> findByArticles(Articles articles);
	List<Boutiques> findByImages(Images images);
	List<Boutiques> findByNom(String nom);
	
	@Query("SELECT COUNT(b) > 0 FROM Boutiques b WHERE LOWER(b.nom) = LOWER(:nom) AND b.boutique_id != :id")
    boolean existsByLibelleBoutiqueAndNotId(@Param("nom") String nom, @Param("id") Long id);
	
	@Query("SELECT CASE WHEN COUNT(b) > 0 THEN TRUE ELSE FALSE END FROM Boutiques b WHERE LOWER(b.nom) = LOWER(:nom)")
	boolean existsByLibelleBoutiqueIgnoreCase(@Param("nom") String nom);
}
