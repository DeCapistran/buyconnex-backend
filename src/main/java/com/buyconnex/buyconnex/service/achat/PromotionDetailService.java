package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.achat.PromotionsDetails;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.mapper.achat.PromotionDetailMapper;
import com.buyconnex.buyconnex.mapper.achat.PromotionMapper;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.repository.achat.PromotionDetailRepository;
import com.buyconnex.buyconnex.repository.achat.PromotionRepository;
import com.buyconnex.buyconnex.repository.article.ArticleRepository;
import com.buyconnex.buyconnex.vo.achat.PromotionsDetailsVo;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PromotionDetailService implements IPromotionDetailService {

	@Autowired
	PromotionDetailRepository promotionDetailRepository;

	@Autowired
	PromotionRepository promotionRepository;

	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Optional<PromotionsDetailsVo> findById(Long id) {
		return promotionDetailRepository.findById(id).map(PromotionDetailMapper::toVO);
	}

	@Override
	public List<PromotionsDetailsVo> findAll() {
		return promotionDetailRepository.findAll().stream()
				.map(PromotionDetailMapper::toVO)
				.collect(Collectors.toList());
	}

	@Override
	public PromotionsDetailsVo savePromotionsDetails(PromotionsDetailsVo promotionsDetailsVo) {
		PromotionsDetails entity = new PromotionsDetails();
		resolveRelations(entity, promotionsDetailsVo);
		PromotionsDetails saved = promotionDetailRepository.save(entity);
		return PromotionDetailMapper.toVO(saved);
	}

	@Override
	public void deletePromotionsDetails(PromotionsDetailsVo promotionsDetailsVo) {
		PromotionsDetails entity = PromotionDetailMapper.toEntity(promotionsDetailsVo);
		promotionDetailRepository.delete(entity);
	}

	@Override
	public void deletePromotionDetailsById(Long id) {
		promotionDetailRepository.deleteById(id);
	}

	@Override
	public PromotionsDetailsVo updatePromotionsDetails(Long id, PromotionsDetailsVo promotionsDetailsVo) {
		return promotionDetailRepository.findById(id).map(entity -> {
			resolveRelations(entity, promotionsDetailsVo);
			PromotionsDetails updated = promotionDetailRepository.save(entity);
			return PromotionDetailMapper.toVO(updated);
		}).orElse(null);
	}

	@Override
	public List<PromotionsDetailsVo> findByPromotions(PromotionsVo promotionsVo) {
		Promotions promotions = PromotionMapper.toEntityRef(promotionsVo);
		return promotionDetailRepository.findByPromotions(promotions).stream()
				.map(PromotionDetailMapper::toVO)
				.collect(Collectors.toList());
	}

	@Override
	public List<PromotionsDetailsVo> findByArticles(ArticlesVo articlesVo) {
		Articles articles = ArticleMapper.toEntity(articlesVo);
		return promotionDetailRepository.findByArticles(articles).stream()
				.map(PromotionDetailMapper::toVO)
				.collect(Collectors.toList());
	}

	private void resolveRelations(PromotionsDetails entity, PromotionsDetailsVo vo) {
		if (vo.getArticlesVo() != null && vo.getArticlesVo().getId() != null) {
			Articles articles = articleRepository.findById(vo.getArticlesVo().getId())
					.orElseThrow(() -> new RuntimeException("Article non trouvé."));
			entity.setArticles(articles);
		}
		if (vo.getPromotionsVo() != null && vo.getPromotionsVo().getId() != null) {
			Promotions promotions = promotionRepository.findById(vo.getPromotionsVo().getId())
					.orElseThrow(() -> new RuntimeException("Promotion non trouvée."));
			entity.setPromotions(promotions);
		}
	}

}
