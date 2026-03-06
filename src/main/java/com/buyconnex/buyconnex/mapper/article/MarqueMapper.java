package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.vo.article.MarquesVo;

public class MarqueMapper {

	public static MarquesVo toVO(Marques marques) {
		if(marques == null) return null;
		MarquesVo marquesVo = new MarquesVo();
		marquesVo.setId(marques.getMarque_id());
		marquesVo.setLibelle(marques.getLibelle());
		marquesVo.setDescription(marques.getDescription());
		
		return marquesVo;
	}
	
	public static Marques toEntity(MarquesVo marquesVo) {
		if(marquesVo == null) return null;
		Marques marques = new Marques();
		marques.setMarque_id(marquesVo.getId());
		marques.setLibelle(marquesVo.getLibelle());
		marques.setDescription(marquesVo.getDescription());
		
		return marques;
	}
	
	public static void updateEntityFromVO(MarquesVo marquesVo, Marques marques) {
		marques.setLibelle(marquesVo.getLibelle());
		marques.setDescription(marquesVo.getDescription());	
	}
}
