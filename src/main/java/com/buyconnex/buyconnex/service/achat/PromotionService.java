package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.repository.achat.PromotionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PromotionService implements IPromotionService {

	@Autowired
	PromotionRepository promotionRepository;
	
	@Override
	public Optional<Promotions> findById(Long id) {
		return promotionRepository.findById(id);
	}

	@Override
	public Promotions savePromotions(Promotions promotions) {
		return promotionRepository.save(promotions);
	}

	@Override
	public void deletePromotions(Promotions promotions) {
		promotionRepository.delete(promotions);
	}

	@Override
	public Promotions updatePromotions(Promotions promotions) {
		return promotionRepository.save(promotions);
	}

	@Override
	public List<Promotions> findByArticles(Articles articles) {
		return promotionRepository.findByArticles(articles);
	}

	@Override
	public List<Promotions> findByDateFin(Date date) {
		return promotionRepository.findByDateFin(date);
	}

	@Override
	public List<Promotions> findByDateDebut(Date date) {
		return promotionRepository.findByDateDebut(date);
	}

	@Override
	public List<Promotions> findByPourcentage(int pourcentage) {
		return promotionRepository.findByPourcentage(pourcentage);
	}

}
