package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Marques;


public interface MarqueRepository extends JpaRepository<Marques, Long> {

	List<Marques> findByArticles(Articles articles);
	List<Marques> findByDescription(String description);
	List<Marques> findByLibelle(String libelle);
	
	@Query("SELECT COUNT(m) > 0 FROM Marques m WHERE LOWER(m.libelle) = LOWER(:libelle) AND m.marque_id != :id")
    boolean existsByLibelleMarqueAndNotId(@Param("libelle") String libelle, @Param("id") Long id);
	
	@Query("SELECT CASE WHEN COUNT(m) > 0 THEN TRUE ELSE FALSE END FROM Marques m WHERE LOWER(m.libelle) = LOWER(:libelle)")
	boolean existsByLibelleMarqueIgnoreCase(@Param("libelle") String libelle);
}
