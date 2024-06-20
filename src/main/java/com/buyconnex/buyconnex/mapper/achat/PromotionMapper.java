package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;

public class PromotionMapper {

	public static PromotionsVo toVo(Promotions promotions) {
		PromotionsVo promotionsVo = new PromotionsVo();
		promotionsVo.setDateCreation(promotions.getDateCreation());
		promotionsVo.setDateDebut(promotions.getDateDebut());
		promotionsVo.setDateFin(promotions.getDateFin());
		promotionsVo.setPourcentage(promotions.getPourcentage());
		promotionsVo.setArticles(promotions.getArticles());
		
		return promotionsVo;
	}
	
	public static Promotions toEntity(PromotionsVo promotionsVo) {
		Promotions promotions = new Promotions();
		promotions.setDateCreation(promotionsVo.getDateCreation());
		promotions.setDateDebut(promotionsVo.getDateDebut());
		promotions.setDateFin(promotionsVo.getDateFin());
		promotions.setPourcentage(promotionsVo.getPourcentage());
		promotions.setArticles(promotionsVo.getArticles());
		
		return promotions;
	}
}
