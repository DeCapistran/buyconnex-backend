package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.achat.PromotionsDetails;
import com.buyconnex.buyconnex.entity.article.Articles;


public interface PromotionDetailRepository extends JpaRepository<PromotionsDetails, Long> {

	List<PromotionsDetails> findByArticles(Articles articles);
	List<PromotionsDetails> findByPromotions(Promotions promotions);
	
}
