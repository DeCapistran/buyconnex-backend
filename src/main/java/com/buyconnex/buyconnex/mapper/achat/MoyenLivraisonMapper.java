package com.buyconnex.buyconnex.mapper.achat;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
import com.buyconnex.buyconnex.vo.achat.MoyensLivraisonsVo;

public class MoyenLivraisonMapper {

	public static MoyensLivraisonsVo toVO(MoyensLivraisons moyensLivraisons) {
		
		MoyensLivraisonsVo moyensLivraisonsVo = new MoyensLivraisonsVo();
		moyensLivraisonsVo.setCommandes(moyensLivraisons.getCommandes().stream().map(CommandeMapper::toVO).collect(Collectors.toSet()));
		moyensLivraisonsVo.setDescription(moyensLivraisons.getDescription());
		moyensLivraisonsVo.setMoyenLivraisons(moyensLivraisons.getMoyenLivraison());
		
		return moyensLivraisonsVo;
	}
	
	public static MoyensLivraisons toEntity(MoyensLivraisonsVo moyensLivraisonsVo) {
		
		MoyensLivraisons moyensLivraisons = new MoyensLivraisons();
		moyensLivraisons.setCommandes(moyensLivraisonsVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		moyensLivraisons.setDescription(moyensLivraisonsVo.getDescription());
		moyensLivraisons.setMoyenLivraison(moyensLivraisonsVo.getMoyenLivraisons());
		
		return moyensLivraisons;
	}

	public static void updateEntityFromVO(MoyensLivraisonsVo moyensLivraisonsVo, MoyensLivraisons moyensLivraisons) {
		
		moyensLivraisons.setCommandes(moyensLivraisonsVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		moyensLivraisons.setDescription(moyensLivraisonsVo.getDescription());
		moyensLivraisons.setMoyenLivraison(moyensLivraisonsVo.getMoyenLivraisons());
	}
}
