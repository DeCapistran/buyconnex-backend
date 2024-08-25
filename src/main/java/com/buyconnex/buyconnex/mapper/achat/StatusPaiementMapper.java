package com.buyconnex.buyconnex.mapper.achat;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.StatusPaiements;
import com.buyconnex.buyconnex.vo.achat.StatusPaiementsVo;

public class StatusPaiementMapper {

	public static StatusPaiementsVo toVO(StatusPaiements statusPaiements) {
		StatusPaiementsVo statusPaiementsVo = new StatusPaiementsVo();
		statusPaiementsVo.setId(statusPaiements.getStatus_paiement_id());
		statusPaiementsVo.setDescription(statusPaiements.getDescription());
		statusPaiementsVo.setPaiements(statusPaiements.getPaiements().stream().map(PaiementMapper::toVO).collect(Collectors.toSet()));
		statusPaiementsVo.setStatus(statusPaiements.getStatus());
		
		return statusPaiementsVo;
	}
	
	public static StatusPaiements toEntity(StatusPaiementsVo statusPaiementsVo) {
		StatusPaiements statusPaiements = new StatusPaiements();
		statusPaiements.setStatus_paiement_id(statusPaiementsVo.getId());
		statusPaiements.setDescription(statusPaiementsVo.getDescription());
		statusPaiements.setPaiements(statusPaiementsVo.getPaiements().stream().map(PaiementMapper::toEntity).collect(Collectors.toSet()));
		statusPaiements.setStatus(statusPaiementsVo.getStatus());
		
		return statusPaiements;
	}
	
	public static void updateEntityFromVO(StatusPaiementsVo statusPaiementsVo, StatusPaiements statusPaiements) {
		statusPaiements.setStatus_paiement_id(statusPaiementsVo.getId());
		statusPaiements.setDescription(statusPaiementsVo.getDescription());
		statusPaiements.setPaiements(statusPaiementsVo.getPaiements().stream().map(PaiementMapper::toEntity).collect(Collectors.toSet()));
		statusPaiements.setStatus(statusPaiementsVo.getStatus());
	}
}
