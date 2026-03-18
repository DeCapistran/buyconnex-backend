package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.vo.article.CouleursVo;

public class CouleurMapper {

	public static CouleursVo toVO(Couleurs couleurs) {
		if(couleurs == null) return null;
		CouleursVo couleursVo = new CouleursVo();
		couleursVo.setId(couleurs.getCouleur_id());
		couleursVo.setCouleur(couleurs.getCouleur());
		couleursVo.setCodeCouleur(couleurs.getCodeCouleur());
		
		return couleursVo;
	}
	
	public static Couleurs toEntity(CouleursVo couleursVo) {
		if(couleursVo == null) return null;
		Couleurs couleurs = new Couleurs();
		couleurs.setCouleur_id(couleursVo.getId());
		couleurs.setCouleur(couleursVo.getCouleur());
		couleurs.setCodeCouleur(couleursVo.getCodeCouleur());
		
		return couleurs;
	}
	
	public static void updateEntityFromVO(CouleursVo couleursVo, Couleurs couleurs) {
		couleurs.setCouleur_id(couleursVo.getId());
		couleurs.setCouleur(couleursVo.getCouleur());
		couleurs.setCodeCouleur(couleursVo.getCodeCouleur());
		
	}
}
