package com.buyconnex.buyconnex.repository.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.SousCategories;



public interface SousCategorieRepository extends JpaRepository<SousCategories, Long> {

	List<SousCategories> findByCategories(Categories categories);
	List<SousCategories> findByCoupons(Coupons coupons);
	List<SousCategories> findByLibelle(String libelle);
	boolean existByLibelle(String libelle);
}
