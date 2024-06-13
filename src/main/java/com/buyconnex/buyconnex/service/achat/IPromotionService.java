package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.article.Articles;

public interface IPromotionService {

	public Optional<Promotions> findById(Long id);
	public Promotions savePromotions(Promotions promotions);
	public void deletePromotions(Promotions promotions);
	public Promotions updatePromotions(Promotions promotions);
	public List<Promotions> findByArticles(Articles articles);
	public List<Promotions> findByDateFin(Date date);
	public List<Promotions> findByDateDebut(Date date);
	public List<Promotions> findByPourcentage(int pourcentage);
}
