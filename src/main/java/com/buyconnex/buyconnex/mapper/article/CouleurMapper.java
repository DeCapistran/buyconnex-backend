package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.vo.article.CouleursVo;

public class CouleurMapper {

	public static CouleursVo toVO(Couleurs couleurs) {
		CouleursVo couleursVo = new CouleursVo();
		couleursVo.setCouleur(couleurs.getCouleur());
		couleursVo.setCodeCouleur(couleurs.getCodeCouleur());
		couleursVo.setImages(couleurs.getImages().stream().map(ImageMapper::toVO).collect(Collectors.toSet()));
		
		return couleursVo;
	}
	
	public static Couleurs toEntity(CouleursVo couleursVo) {
		Couleurs couleurs = new Couleurs();
		couleurs.setCouleur(couleursVo.getCouleur());
		couleurs.setCodeCouleur(couleursVo.getCodeCouleur());
		couleurs.setImages(couleursVo.getImages().stream().map(ImageMapper::toEntity).collect(Collectors.toSet()));
		
		return couleurs;
	}
	
	public static void updateEntityFromVO(CouleursVo couleursVo, Couleurs couleurs) {
		
		couleurs.setCouleur(couleursVo.getCouleur());
		couleurs.setCodeCouleur(couleursVo.getCodeCouleur());
		couleurs.setImages(couleursVo.getImages().stream().map(ImageMapper::toEntity).collect(Collectors.toSet()));
		
	}
}
