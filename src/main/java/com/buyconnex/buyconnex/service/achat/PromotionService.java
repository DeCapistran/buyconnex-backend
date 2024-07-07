package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.mapper.achat.PromotionMapper;
import com.buyconnex.buyconnex.repository.achat.PromotionRepository;
import com.buyconnex.buyconnex.repository.article.ArticleRepository;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PromotionService implements IPromotionService {

	@Autowired
	PromotionRepository promotionRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Override
	public Optional<PromotionsVo> findById(Long id) {
		return promotionRepository.findById(id).map(PromotionMapper::toVo);
	}

	@Override
	public PromotionsVo savePromotions(PromotionsVo promotionsVo) {
		Promotions promotions = PromotionMapper.toEntity(promotionsVo);
		promotions.getPromotionsDetails().forEach(promotionDetail -> {
			Articles articles = articleRepository.findById(promotionDetail.getArticles().getArticle_id())
					.orElseThrow(() -> new RuntimeException("Article non trouvé."));
					promotionDetail.setArticles(articles);
					promotionDetail.setPromotions(promotions);
		});
		Promotions promotionsSave = promotionRepository.save(promotions);
		return PromotionMapper.toVo(promotionsSave);
	}

	@Override
	public void deletePromotions(PromotionsVo promotionsVo) {
		Promotions promotions = PromotionMapper.toEntity(promotionsVo);
		promotionRepository.delete(promotions);
	}

	@Override
	public PromotionsVo updatePromotions(Long id, PromotionsVo promotionsVo) {
		return promotionRepository.findById(id).map(promotion -> {
			PromotionMapper.updateEntityFromVO(promotionsVo, promotion);
			Promotions promotionsUpdated = promotionRepository.save(promotion);
			return PromotionMapper.toVo(promotionsUpdated);
		}).orElse(null);
	}

	@Override
	public List<PromotionsVo> findByDateFin(Date date) {
		return promotionRepository.findByDateFin(date).stream().map(PromotionMapper::toVo).collect(Collectors.toList());
	}

	@Override
	public List<PromotionsVo> findByDateDebut(Date date) {
		return promotionRepository.findByDateDebut(date).stream().map(PromotionMapper::toVo).collect(Collectors.toList());
	}

	@Override
	public List<PromotionsVo> findByPourcentage(int pourcentage) {
		return promotionRepository.findByPourcentage(pourcentage).stream().map(PromotionMapper::toVo).collect(Collectors.toList());
	}

	@Override
	public List<PromotionsVo> findAll() {
		return promotionRepository.findAll().stream().map(PromotionMapper::toVo).collect(Collectors.toList());
	}

	@Override
	public void deletePromotionsById(Long id) {
		promotionRepository.deleteById(id);
	}

}
