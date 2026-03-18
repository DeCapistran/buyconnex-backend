package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Expeditions;
import com.buyconnex.buyconnex.vo.achat.ExpeditionsVo;

public class ExpeditionMapper {

	public static ExpeditionsVo toVO(Expeditions expeditions) {
		if(expeditions == null) return null;
		ExpeditionsVo expeditionsVo = new ExpeditionsVo();
		expeditionsVo.setId(expeditions.getExpedition_id());
		expeditionsVo.setCommentaire(expeditions.getCommentaire());
		expeditionsVo.setDateExpedition(expeditions.getDateExpedition());
		expeditionsVo.setIdCommande(expeditions.getCommandes() != null ? expeditions.getCommandes().getCommande_id() : null);

		
		return expeditionsVo;
	}
	
	public static Expeditions toEntity(ExpeditionsVo expeditionsVo) {
		if(expeditionsVo == null) return null;
		Expeditions expeditions = new Expeditions();
		expeditions.setExpedition_id(expeditionsVo.getId());
		expeditions.setCommentaire(expeditionsVo.getCommentaire());
		expeditions.setDateExpedition(expeditionsVo.getDateExpedition());
		if (expeditionsVo.getIdCommande() != null) {
	        Commandes cmd = new Commandes();
	        cmd.setCommande_id(expeditionsVo.getIdCommande());
	        expeditions.setCommandes(cmd);
	    } else {
	        expeditions.setCommandes(null);
	    }
		
		return expeditions;
	}
	
	public static void updateEntityFromVO(ExpeditionsVo expeditionsVo, Expeditions expeditions) {
		expeditions.setExpedition_id(expeditionsVo.getId());
		expeditions.setCommentaire(expeditionsVo.getCommentaire());
		expeditions.setDateExpedition(expeditionsVo.getDateExpedition());
		if (expeditionsVo.getIdCommande() != null) {
	        Commandes cmd = new Commandes();
	        cmd.setCommande_id(expeditionsVo.getIdCommande());
	        expeditions.setCommandes(cmd);
	    } else {
	        expeditions.setCommandes(null);
	    }
	}
}
