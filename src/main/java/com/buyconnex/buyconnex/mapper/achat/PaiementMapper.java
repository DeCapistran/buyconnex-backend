package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;

public class PaiementMapper {

	public static PaiementsVo toVO(Paiements paiements) {
		PaiementsVo paiementsVo = new PaiementsVo();
		paiementsVo.setId(paiements.getPaiement_id());
		paiementsVo.setDatePaiement(paiements.getDatePaiement());
		paiementsVo.setMontant(paiements.getMontant());
		paiementsVo.setMoyensPaiements(MoyenPaiementMapper.toVO(paiements.getMoyensPaiements()));
		paiementsVo.setStatusPaiements(StatusPaiementMapper.toVO(paiements.getStatusPaiements()));
		
		return paiementsVo;
	}
	
	public static Paiements toEntity(PaiementsVo paiementsVo) {
		Paiements paiements = new Paiements();
		paiements.setPaiement_id(paiementsVo.getId());
		paiements.setDatePaiement(paiementsVo.getDatePaiement());
		paiements.setMontant(paiementsVo.getMontant());
		paiements.setMoyensPaiements(MoyenPaiementMapper.toEntity(paiementsVo.getMoyensPaiements()));
		paiements.setStatusPaiements(StatusPaiementMapper.toEntity(paiementsVo.getStatusPaiements()));
		
		return paiements;
	}
	
	public static void updateEntityFromVO(PaiementsVo paiementsVo, Paiements paiements) {
		paiements.setPaiement_id(paiementsVo.getId());
		paiements.setDatePaiement(paiementsVo.getDatePaiement());
		paiements.setMontant(paiementsVo.getMontant());
		paiements.setMoyensPaiements(MoyenPaiementMapper.toEntity(paiementsVo.getMoyensPaiements()));
		paiements.setStatusPaiements(StatusPaiementMapper.toEntity(paiementsVo.getStatusPaiements()));
	}
}
