package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.vo.article.BoutiquesVo;

public class BoutiqueMapper {

	public static BoutiquesVo toVO(Boutiques boutiques) {
		BoutiquesVo boutiquesVo = new BoutiquesVo();
		boutiquesVo.setNom(boutiques.getNom());
		boutiquesVo.setEmail(boutiques.getEmail());
		boutiquesVo.setTelephone(boutiques.getTelephone());
		boutiquesVo.setImg(boutiques.getImg());
		boutiquesVo.setArticles(boutiques.getArticles());
		
		return boutiquesVo;
	}
	
	public static Boutiques toEntity(BoutiquesVo boutiquesVo) {
		Boutiques boutiques = new Boutiques();
		boutiques.setNom(boutiquesVo.getNom());
		boutiques.setEmail(boutiquesVo.getEmail());
		boutiques.setTelephone(boutiquesVo.getTelephone());
		boutiques.setImg(boutiquesVo.getImg());
		boutiques.setArticles(boutiquesVo.getArticles());
		
		return boutiques;
	}
	
	public static void updateEntityFromVO(BoutiquesVo boutiquesVo, Boutiques boutiques) {
		
		boutiques.setNom(boutiquesVo.getNom());
		boutiques.setEmail(boutiquesVo.getEmail());
		boutiques.setTelephone(boutiquesVo.getTelephone());
		boutiques.setImg(boutiquesVo.getImg());
		boutiques.setArticles(boutiquesVo.getArticles());
	}
}
