package com.buyconnex.buyconnex.mapper.client;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

public class PanierMapper {

	public static PaniersVo toVO(Paniers paniers) {
		PaniersVo paniersVo = new PaniersVo();
		paniersVo.setDatePanier(paniers.getDatePanier());
		paniersVo.setUsers(UserMapper.toVO(paniers.getUsers()));
		paniersVo.setPaniersDetails(paniers.getPaniersDetails().stream().map(PanierDetailMapper::toVo).collect(Collectors.toSet()));
		
		return paniersVo;
	}
	
	public static Paniers toEntity(PaniersVo paniersVo) {
		Paniers paniers = new Paniers();
		paniers.setDatePanier(paniersVo.getDatePanier());
		paniers.setUsers(UserMapper.toEntity(paniersVo.getUsers()));
		paniers.setPaniersDetails(paniersVo.getPaniersDetails().stream().map(PanierDetailMapper::toEntity).collect(Collectors.toSet()));
		
		return paniers;
	}
	
	public static void updateEntityFromVO(PaniersVo paniersVo, Paniers paniers) {
		
		paniers.setDatePanier(paniersVo.getDatePanier());
		paniers.setUsers(UserMapper.toEntity(paniersVo.getUsers()));
		paniers.setPaniersDetails(paniersVo.getPaniersDetails().stream().map(PanierDetailMapper::toEntity).collect(Collectors.toSet()));
		
	}
}
