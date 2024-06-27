package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.PaniersDetails;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.vo.client.PaniersDetailsVo;

public class PanierDetailMapper {

	public static PaniersDetailsVo toVo(PaniersDetails paniersDetails) {
		PaniersDetailsVo paniersDetailsVo = new PaniersDetailsVo();
		paniersDetailsVo.setArticlesVo(ArticleMapper.toVO(paniersDetails.getArticles()));
		paniersDetailsVo.setPaniersVo(PanierMapper.toVO(paniersDetails.getPaniers()));
		
		return paniersDetailsVo;
	}
	
	public static PaniersDetails toEntity(PaniersDetailsVo paniersDetailsVo) {
		PaniersDetails paniersDetails = new PaniersDetails();
		paniersDetails.setArticles(ArticleMapper.toEntity(paniersDetailsVo.getArticlesVo()));
		paniersDetails.setPaniers(PanierMapper.toEntity(paniersDetailsVo.getPaniersVo()));
		
		return paniersDetails;
	}
	
	public static void updateEntityFromVo(PaniersDetails paniersDetails, PaniersDetailsVo paniersDetailsVo) {
		paniersDetails.setArticles(ArticleMapper.toEntity(paniersDetailsVo.getArticlesVo()));
		paniersDetails.setPaniers(PanierMapper.toEntity(paniersDetailsVo.getPaniersVo()));
	}
}
