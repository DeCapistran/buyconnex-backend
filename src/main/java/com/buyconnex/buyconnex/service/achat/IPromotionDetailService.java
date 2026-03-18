package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.PromotionsDetailsVo;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

public interface IPromotionDetailService {

	public Optional<PromotionsDetailsVo> findById(Long id);
	public List<PromotionsDetailsVo> findAll();
	public PromotionsDetailsVo savePromotionsDetails(PromotionsDetailsVo promotionsDetailsVo);
	public void deletePromotionsDetails(PromotionsDetailsVo promotionsDetailsVo);
	public void deletePromotionDetailsById(Long id);
	public PromotionsDetailsVo updatePromotionsDetails(Long id, PromotionsDetailsVo promotionsDetailsVo);
	public List<PromotionsDetailsVo> findByPromotions(PromotionsVo promotionsVo);
	public List<PromotionsDetailsVo> findByArticles(ArticlesVo articlesVo);
}
