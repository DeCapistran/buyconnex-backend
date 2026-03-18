package com.buyconnex.buyconnex.repository.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.entity.client.PaniersDetails;


public interface PanierDetailRepository extends JpaRepository<PaniersDetails, Long>{

	List<PaniersDetails> findByArticles(Articles articles);
	List<PaniersDetails> findByPaniers(Paniers paniers);
}
