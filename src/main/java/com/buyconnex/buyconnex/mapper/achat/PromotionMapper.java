package com.buyconnex.buyconnex.mapper.achat;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;

public class PromotionMapper {

	public static PromotionsVo toVo(Promotions promotions) {
		PromotionsVo promotionsVo = new PromotionsVo();
		promotionsVo.setDateCreation(promotions.getDateCreation());
		promotionsVo.setDateDebut(promotions.getDateDebut());
		promotionsVo.setDateFin(promotions.getDateFin());
		promotionsVo.setPourcentage(promotions.getPourcentage());
		promotionsVo.setLibelle(promotions.getLibelle());
		promotionsVo.setDescription(promotions.getDescription());
		promotionsVo.setPromotionsDetails(promotions.getPromotionsDetails().stream().map(PromotionDetailMapper::toVO).collect(Collectors.toSet()));
		
		return promotionsVo;
	}
	
	public static Promotions toEntity(PromotionsVo promotionsVo) {
		Promotions promotions = new Promotions();
		promotions.setDateCreation(promotionsVo.getDateCreation());
		promotions.setDateDebut(promotionsVo.getDateDebut());
		promotions.setDateFin(promotionsVo.getDateFin());
		promotions.setPourcentage(promotionsVo.getPourcentage());
		promotions.setLibelle(promotionsVo.getLibelle());
		promotions.setDescription(promotionsVo.getDescription());
		promotions.setPromotionsDetails(promotionsVo.getPromotionsDetails().stream().map(PromotionDetailMapper::toEntity).collect(Collectors.toSet()));
		
		return promotions;
	}
	
	public static void updateEntityFromVO(PromotionsVo promotionsVo, Promotions promotions) {
		
		promotions.setDateCreation(promotionsVo.getDateCreation());
		promotions.setDateDebut(promotionsVo.getDateDebut());
		promotions.setDateFin(promotionsVo.getDateFin());
		promotions.setPourcentage(promotionsVo.getPourcentage());
		promotions.setLibelle(promotionsVo.getLibelle());
		promotions.setDescription(promotionsVo.getDescription());
		promotions.setPromotionsDetails(promotionsVo.getPromotionsDetails().stream().map(PromotionDetailMapper::toEntity).collect(Collectors.toSet()));
		
	}
}
