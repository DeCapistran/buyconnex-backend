package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

public class PanierMapper {

	public static PaniersVo toVO(Paniers paniers) {
		PaniersVo paniersVo = new PaniersVo();
		paniersVo.setArticles(paniers.getArticles());
		paniersVo.setDatePanier(paniers.getDatePanier());
		paniersVo.setUsers(paniers.getUsers());
		
		return paniersVo;
	}
	
	public static Paniers toEntity(PaniersVo paniersVo) {
		Paniers paniers = new Paniers();
		paniers.setArticles(paniersVo.getArticles());
		paniers.setDatePanier(paniersVo.getDatePanier());
		paniers.setUsers(paniersVo.getUsers());
		
		return paniers;
	}
}
