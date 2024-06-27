package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

public class PanierMapper {

	public static PaniersVo toVO(Paniers paniers) {
		PaniersVo paniersVo = new PaniersVo();
		paniersVo.setDatePanier(paniers.getDatePanier());
		paniersVo.setUsers(UserMapper.toVO(paniers.getUsers()));
		
		return paniersVo;
	}
	
	public static Paniers toEntity(PaniersVo paniersVo) {
		Paniers paniers = new Paniers();
		paniers.setDatePanier(paniersVo.getDatePanier());
		paniers.setUsers(UserMapper.toEntity(paniersVo.getUsers()));
		
		return paniers;
	}
	
	public static void updateEntityFromVO(PaniersVo paniersVo, Paniers paniers) {
		
		paniers.setDatePanier(paniersVo.getDatePanier());
		paniers.setUsers(UserMapper.toEntity(paniersVo.getUsers()));
	}
}
