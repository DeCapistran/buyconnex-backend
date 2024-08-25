package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.article.AvisVo;

public class AvisMapper {

	public static AvisVo toVO(Avis avis) {
		AvisVo avisVo = new AvisVo();
		avisVo.setId(avis.getAvis_id());
		avisVo.setDateAvis(avis.getDateAvis());
		avisVo.setEtoile(avis.getEtoile());
		avisVo.setCommentaire(avis.getCommentaire());
		avisVo.setArticles(ArticleMapper.toVO(avis.getArticles()));
		avisVo.setUsers(UserMapper.toVO(avis.getUsers()));
		
		return avisVo;
	}
	
	public static Avis toEntity(AvisVo avisVo) {
		Avis avis = new Avis();
		avis.setAvis_id(avisVo.getId());
		avis.setDateAvis(avisVo.getDateAvis());
		avis.setEtoile(avisVo.getEtoile());
		avis.setCommentaire(avisVo.getCommentaire());
		avis.setArticles(ArticleMapper.toEntity(avisVo.getArticles()));
		avis.setUsers(UserMapper.toEntity(avisVo.getUsers()));
		
		return avis;
	}
	
	public static void updateEntityFromVO(AvisVo avisVo, Avis avis) {
		avis.setAvis_id(avisVo.getId());
		avis.setDateAvis(avisVo.getDateAvis());
		avis.setEtoile(avisVo.getEtoile());
		avis.setCommentaire(avisVo.getCommentaire());
		avis.setArticles(ArticleMapper.toEntity(avisVo.getArticles()));
		avis.setUsers(UserMapper.toEntity(avisVo.getUsers()));
	}
}
