package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.visuel.Sliders;



public interface ImageRepository extends JpaRepository<Images, Long> {

	List<Images> findByCategories(Categories categories);
	List<Images> findByBoutiques(Boutiques boutiques);
	List<Images> findByName(String name);
	List<Images> findBySliders(Sliders sliders);
	List<Images> findByCouleurs(Couleurs couleurs);
}
