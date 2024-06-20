package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.vo.article.MarquesVo;

public class MarqueMapper {

	public static MarquesVo toVO(Marques marques) {
		MarquesVo marquesVo = new MarquesVo();
		marquesVo.setLibelle(marques.getLibelle());
		marquesVo.setImg(marques.getImg());
		marquesVo.setArticles(marques.getArticles());
		
		return marquesVo;
	}
	
	public static Marques toEntity(MarquesVo marquesVo) {
		Marques marques = new Marques();
		marques.setLibelle(marquesVo.getLibelle());
		marques.setImg(marquesVo.getImg());
		marques.setArticles(marquesVo.getArticles());
		
		return marques;
	}
}
