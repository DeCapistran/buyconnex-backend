package com.buyconnex.buyconnex.mapper.client;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

public class PanierMapper {

	public static PaniersVo toVO(Paniers paniers) {
		PaniersVo paniersVo = new PaniersVo();
		paniersVo.setArticles(paniers.getArticles().stream().map(ArticleMapper::toVO).collect(Collectors.toSet()));
		paniersVo.setDatePanier(paniers.getDatePanier());
		paniersVo.setUsers(UserMapper.toVO(paniers.getUsers()));
		
		return paniersVo;
	}
	
	public static Paniers toEntity(PaniersVo paniersVo) {
		Paniers paniers = new Paniers();
		paniers.setArticles(paniersVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		paniers.setDatePanier(paniersVo.getDatePanier());
		paniers.setUsers(UserMapper.toEntity(paniersVo.getUsers()));
		
		return paniers;
	}
	
	public static void updateEntityFromVO(PaniersVo paniersVo, Paniers paniers) {
		
		paniers.setArticles(paniersVo.getArticles().stream().map(ArticleMapper::toEntity).collect(Collectors.toSet()));
		paniers.setDatePanier(paniersVo.getDatePanier());
		paniers.setUsers(UserMapper.toEntity(paniersVo.getUsers()));
	}
}
