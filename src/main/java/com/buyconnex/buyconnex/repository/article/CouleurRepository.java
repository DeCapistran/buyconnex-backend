package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.entity.article.Images;



public interface CouleurRepository extends JpaRepository<Couleurs, Long> {

	List<Couleurs> findByCodeCouleur(String codeCouleur);
	List<Couleurs> findByCouleur(String couleur);
	List<Couleurs> findByImages(Images images);
}
