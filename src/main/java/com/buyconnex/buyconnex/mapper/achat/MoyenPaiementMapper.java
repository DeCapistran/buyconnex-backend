package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.vo.achat.MoyensPaiementsVo;

public class MoyenPaiementMapper {

	public static MoyensPaiementsVo toVO(MoyensPaiements moyensPaiements) {
		MoyensPaiementsVo moyensPaiementsVo = new MoyensPaiementsVo();
		moyensPaiementsVo.setMoyensPaiements(moyensPaiements.getMoyenPaiement());
		moyensPaiementsVo.setDescription(moyensPaiements.getDescription());
		moyensPaiementsVo.setPaiements(moyensPaiements.getPaiements());
		
		return moyensPaiementsVo;
	}
	
	public static MoyensPaiements toEntity(MoyensPaiementsVo moyensPaiementsVo) {
		MoyensPaiements moyensPaiements = new MoyensPaiements();
		moyensPaiements.setMoyenPaiement(moyensPaiementsVo.getMoyensPaiements());
		moyensPaiements.setDescription(moyensPaiementsVo.getDescription());
		moyensPaiements.setPaiements(moyensPaiementsVo.getPaiements());
		
		return moyensPaiements;
	}
	
	public static void updateEntityFromVO(MoyensPaiementsVo moyensPaiementsVo, MoyensPaiements moyensPaiements) {
		
		moyensPaiements.setMoyenPaiement(moyensPaiementsVo.getMoyensPaiements());
		moyensPaiements.setDescription(moyensPaiementsVo.getDescription());
		moyensPaiements.setPaiements(moyensPaiementsVo.getPaiements());
	}
}
