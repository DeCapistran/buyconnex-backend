package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.PromotionsDetails;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.vo.achat.PromotionsDetailsVo;

public class PromotionDetailMapper {

	public static PromotionsDetailsVo toVO(PromotionsDetails promotionsDetails) {
		PromotionsDetailsVo promotionsDetailsVo = new PromotionsDetailsVo();
		promotionsDetailsVo.setArticlesVo(ArticleMapper.toVO(promotionsDetails.getArticles()));
		promotionsDetailsVo.setPromotionsVo(PromotionMapper.toVo(promotionsDetails.getPromotions()));
		
		return promotionsDetailsVo;
	}
	
	public static PromotionsDetails toEntity(PromotionsDetailsVo promotionsDetailsVo) {
		PromotionsDetails promotionsDetails = new PromotionsDetails();
		promotionsDetails.setArticles(ArticleMapper.toEntity(promotionsDetailsVo.getArticlesVo()));
		promotionsDetails.setPromotions(PromotionMapper.toEntity(promotionsDetailsVo.getPromotionsVo()));
		
		return promotionsDetails;
	}
	
	public static void updateEntityFromVo(PromotionsDetails promotionsDetails, PromotionsDetailsVo promotionsDetailsVo) {
		promotionsDetails.setArticles(ArticleMapper.toEntity(promotionsDetailsVo.getArticlesVo()));
		promotionsDetails.setPromotions(PromotionMapper.toEntity(promotionsDetailsVo.getPromotionsVo()));

	}
}
