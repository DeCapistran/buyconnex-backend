package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.buyconnex.buyconnex.entity.article.Tags;


public interface TagRepository extends JpaRepository<Tags, Long> {

	List<Tags> findByNom(String nom);
	List<Tags> findByDescription(String description);
	
	@Query("SELECT COUNT(t) > 0 FROM Tags t WHERE LOWER(t.nom) = LOWER(:nom) AND t.tags_id != :id")
    boolean existsByNomTagAndNotId(@Param("nom") String nom, @Param("id") Long id);
	
	@Query("SELECT CASE WHEN COUNT(t) > 0 THEN TRUE ELSE FALSE END FROM Tags t WHERE LOWER(t.nom) = LOWER(:nom)")
	boolean existsByNomTagIgnoreCase(@Param("nom") String nom);
}
