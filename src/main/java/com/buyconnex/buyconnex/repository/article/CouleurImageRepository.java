package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.entity.article.CouleursImages;
import com.buyconnex.buyconnex.entity.article.Images;


public interface CouleurImageRepository extends JpaRepository<CouleursImages, Long>{

	List<CouleursImages> findByCouleurs(Couleurs couleurs);
	List<CouleursImages> findByImages(Images images);
}
