package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Marques;


public interface MarqueRepository extends JpaRepository<Marques, Long> {

	List<Marques> findByArticles(Articles articles);
	List<Marques> findByImg(String img);
	List<Marques> findByLibelle(String libelle);
	//boolean existByLibelle(String libelle);
}
