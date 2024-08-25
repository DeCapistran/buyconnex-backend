package com.buyconnex.buyconnex.mapper.achat;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.vo.achat.MoyensPaiementsVo;

public class MoyenPaiementMapper {

	public static MoyensPaiementsVo toVO(MoyensPaiements moyensPaiements) {
		MoyensPaiementsVo moyensPaiementsVo = new MoyensPaiementsVo();
		moyensPaiementsVo.setId(moyensPaiements.getMoyen_paiement_id());
		moyensPaiementsVo.setMoyensPaiements(moyensPaiements.getMoyenPaiement());
		moyensPaiementsVo.setDescription(moyensPaiements.getDescription());
		moyensPaiementsVo.setPaiements(moyensPaiements.getPaiements().stream().map(PaiementMapper::toVO).collect(Collectors.toSet()));
		
		return moyensPaiementsVo;
	}
	
	public static MoyensPaiements toEntity(MoyensPaiementsVo moyensPaiementsVo) {
		MoyensPaiements moyensPaiements = new MoyensPaiements();
		moyensPaiements.setMoyen_paiement_id(moyensPaiementsVo.getId());
		moyensPaiements.setMoyenPaiement(moyensPaiementsVo.getMoyensPaiements());
		moyensPaiements.setDescription(moyensPaiementsVo.getDescription());
		moyensPaiements.setPaiements(moyensPaiementsVo.getPaiements().stream().map(PaiementMapper::toEntity).collect(Collectors.toSet()));
		
		return moyensPaiements;
	}
	
	public static void updateEntityFromVO(MoyensPaiementsVo moyensPaiementsVo, MoyensPaiements moyensPaiements) {
		moyensPaiements.setMoyen_paiement_id(moyensPaiementsVo.getId());
		moyensPaiements.setMoyenPaiement(moyensPaiementsVo.getMoyensPaiements());
		moyensPaiements.setDescription(moyensPaiementsVo.getDescription());
		moyensPaiements.setPaiements(moyensPaiementsVo.getPaiements().stream().map(PaiementMapper::toEntity).collect(Collectors.toSet()));
	}
}
