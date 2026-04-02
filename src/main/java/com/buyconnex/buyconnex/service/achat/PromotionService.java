package com.buyconnex.buyconnex.service.achat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.achat.PromotionsDetails;
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
	public PromotionsVo savePromotions(String libelle, int pourcentage, Date dateDebut, Date dateFin, String description, List<Long> articlesIds) {
		Promotions promotions = new Promotions();
		promotions.setLibelle(libelle);
		promotions.setPourcentage(pourcentage);
		promotions.setDateDebut(dateDebut);
		promotions.setDateFin(dateFin);
		promotions.setDescription(description);
		promotions.setDateCreation(LocalDateTime.now());
		promotions.setPromotionsDetails(buildDetails(promotions, articlesIds));

		Promotions promotionsSave = promotionRepository.save(promotions);
		return PromotionMapper.toVo(promotionsSave);
	}

	@Override
	public void deletePromotions(PromotionsVo promotionsVo) {
		Promotions promotions = PromotionMapper.toEntity(promotionsVo);
		promotionRepository.delete(promotions);
	}

	@Override
	public PromotionsVo updatePromotions(Long id, String libelle, int pourcentage, Date dateDebut, Date dateFin, String description, List<Long> articlesIds) {
		return promotionRepository.findById(id).map(promotion -> {
			promotion.setLibelle(libelle);
			promotion.setPourcentage(pourcentage);
			promotion.setDateDebut(dateDebut);
			promotion.setDateFin(dateFin);
			promotion.setDescription(description);

			promotion.getPromotionsDetails().clear();
			promotion.getPromotionsDetails().addAll(buildDetails(promotion, articlesIds));

			Promotions promotionsUpdated = promotionRepository.save(promotion);
			return PromotionMapper.toVo(promotionsUpdated);
		}).orElse(null);
	}

	private Set<PromotionsDetails> buildDetails(Promotions promotion, List<Long> articlesIds) {
		Set<PromotionsDetails> details = new HashSet<>();
		if (articlesIds != null && !articlesIds.isEmpty()) {
			for (Long articleId : articlesIds) {
				Articles article = articleRepository.findById(articleId)
						.orElseThrow(() -> new RuntimeException("Article non trouvé avec l'id : " + articleId));
				PromotionsDetails detail = new PromotionsDetails();
				detail.setArticles(article);
				detail.setPromotions(promotion);
				details.add(detail);
			}
		}
		return details;
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

	@Override
	public List<PromotionsVo> findByLibelle(String libelle) {
		return promotionRepository.findByLibelle(libelle).stream().map(PromotionMapper::toVo).collect(Collectors.toList());
	}

	@Override
	public List<PromotionsVo> findByDescription(String description) {
		return promotionRepository.findByDescription(description).stream().map(PromotionMapper::toVo).collect(Collectors.toList());
	}

}
