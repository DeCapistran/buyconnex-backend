package com.buyconnex.buyconnex.mapper.article;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.vo.article.MarquesVo;

public class MarqueMapper {

	public static MarquesVo toVO(Marques marques) {
		MarquesVo marquesVo = new MarquesVo();
		marquesVo.setLibelle(marques.getLibelle());
		marquesVo.setImg(marques.getImg());
		marquesVo.setArticles(marques.getArticles().stream().map(ArticleMapper::toVO).collect(Collectors.toSet()));
		
		return marquesVo;
	}
	
	public static Marques toEntity(MarquesVo marquesVo) {
		Marques marques = new Marques();
		marques.setLibelle(marquesVo.getLibelle());
		marques.setImg(marquesVo.getImg());
		marques.setArticles(marquesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		
		return marques;
	}
	
	public static void updateEntityFromVO(MarquesVo marquesVo, Marques marques) {
		
		marques.setLibelle(marquesVo.getLibelle());
		marques.setImg(marquesVo.getImg());
		marques.setArticles(marquesVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
	}
}
