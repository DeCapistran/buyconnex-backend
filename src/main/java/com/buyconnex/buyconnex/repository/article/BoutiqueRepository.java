package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;


public interface BoutiqueRepository extends JpaRepository<Boutiques, Long> {

	List<Boutiques> findByArticles(Articles articles);
	List<Boutiques> findByNom(String nom);
	List<Boutiques> findByImg(String img);
	boolean existByLibelle(String libelle);
}
