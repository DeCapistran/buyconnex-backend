package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.PromotionsVo;
import com.buyconnex.buyconnex.vo.article.ArticlesVo;

public interface IPromotionService {

	public Optional<PromotionsVo> findById(Long id);
	public PromotionsVo savePromotions(PromotionsVo promotionsVo);
	public void deletePromotions(PromotionsVo promotionsVo);
	public PromotionsVo updatePromotions(Long id, PromotionsVo promotionsVo);
	public List<PromotionsVo> findByArticles(ArticlesVo articlesVo);
	public List<PromotionsVo> findByDateFin(Date date);
	public List<PromotionsVo> findByDateDebut(Date date);
	public List<PromotionsVo> findByPourcentage(int pourcentage);
}
