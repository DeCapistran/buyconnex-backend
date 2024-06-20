package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;

public class PaiementMapper {

	public static PaiementsVo toVO(Paiements paiements) {
		PaiementsVo paiementsVo = new PaiementsVo();
		paiementsVo.setDatePaiement(paiements.getDatePaiement());
		paiementsVo.setMontant(paiements.getMontant());
		paiementsVo.setMoyensPaiements(paiements.getMoyensPaiements());
		paiementsVo.setStatusPaiements(paiements.getStatusPaiements());
		
		return paiementsVo;
	}
	
	public static Paiements toEntity(PaiementsVo paiementsVo) {
		Paiements paiements = new Paiements();
		paiements.setDatePaiement(paiementsVo.getDatePaiement());
		paiements.setMontant(paiementsVo.getMontant());
		paiements.setMoyensPaiements(paiementsVo.getMoyensPaiements());
		paiements.setStatusPaiements(paiementsVo.getStatusPaiements());
		
		return paiements;
	}
}
