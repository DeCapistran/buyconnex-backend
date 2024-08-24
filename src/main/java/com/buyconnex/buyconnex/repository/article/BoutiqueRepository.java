package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Images;


public interface BoutiqueRepository extends JpaRepository<Boutiques, Long> {

	List<Boutiques> findByArticles(Articles articles);
	List<Boutiques> findByImages(Images images);
	List<Boutiques> findByNom(String nom);
	//boolean existByLibelle(String libelle);
}
