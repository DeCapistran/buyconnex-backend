package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Expeditions;
import com.buyconnex.buyconnex.vo.achat.ExpeditionsVo;

public class ExpeditionMapper {

	public static ExpeditionsVo toVO(Expeditions expeditions) {
		ExpeditionsVo expeditionsVo = new ExpeditionsVo();
		expeditionsVo.setCommentaire(expeditions.getCommentaire());
		expeditionsVo.setDateExpedition(expeditions.getDateExpedition());
		expeditionsVo.setCommandes(expeditions.getCommandes());
		
		return expeditionsVo;
	}
	
	public static Expeditions toEntity(ExpeditionsVo expeditionsVo) {
		Expeditions expeditions = new Expeditions();
		expeditions.setCommentaire(expeditionsVo.getCommentaire());
		expeditions.setDateExpedition(expeditionsVo.getDateExpedition());
		expeditions.setCommandes(expeditionsVo.getCommandes());
		
		return expeditions;
	}
	
	public static void updateEntityFromVO(ExpeditionsVo expeditionsVo, Expeditions expeditions) {
		
		expeditions.setCommentaire(expeditionsVo.getCommentaire());
		expeditions.setDateExpedition(expeditionsVo.getDateExpedition());
		expeditions.setCommandes(expeditionsVo.getCommandes());
	}
}
