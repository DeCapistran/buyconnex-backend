package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.SousCategories;



public interface CategorieRepository extends JpaRepository<Categories, Long> {

	List<Categories> findByArticles(Articles articles);
	List<Categories> findByImages(Images images);
	List<Categories> findByLibelle(String libelle);
	List<Categories> findBySousCategorie(SousCategories sousCategorie);
}
