package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.vo.article.AvisVo;

public class AvisMapper {

	public static AvisVo toVO(Avis avis) {
		AvisVo avisVo = new AvisVo();
		avisVo.setDateAvis(avis.getDateAvis());
		avisVo.setEtoile(avis.getEtoile());
		avisVo.setCommentaire(avis.getCommentaire());
		avisVo.setArticles(avis.getArticles());
		avisVo.setUsers(avis.getUsers());
		
		return avisVo;
	}
	
	public static Avis toEntity(AvisVo avisVo) {
		Avis avis = new Avis();
		avis.setDateAvis(avisVo.getDateAvis());
		avis.setEtoile(avisVo.getEtoile());
		avis.setCommentaire(avisVo.getCommentaire());
		avis.setArticles(avisVo.getArticles());
		avis.setUsers(avisVo.getUsers());
		
		return avis;
	}
}
