package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.StatusPaiements;
import com.buyconnex.buyconnex.vo.achat.StatusPaiementsVo;

public class StatusPaiementMapper {

	public static StatusPaiementsVo toVO(StatusPaiements statusPaiements) {
		StatusPaiementsVo statusPaiementsVo = new StatusPaiementsVo();
		statusPaiementsVo.setDescription(statusPaiements.getDescription());
		statusPaiementsVo.setPaiements(statusPaiements.getPaiements());
		statusPaiementsVo.setStatus(statusPaiements.getStatus());
		
		return statusPaiementsVo;
	}
	
	public static StatusPaiements toEntity(StatusPaiementsVo statusPaiementsVo) {
		StatusPaiements statusPaiements = new StatusPaiements();
		statusPaiements.setDescription(statusPaiementsVo.getDescription());
		statusPaiements.setPaiements(statusPaiementsVo.getPaiements());
		statusPaiements.setStatus(statusPaiementsVo.getStatus());
		
		return statusPaiements;
	}
}
