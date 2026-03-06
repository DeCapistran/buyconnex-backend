package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.PaniersDetails;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.vo.client.PaniersDetailsVo;

public class PanierDetailMapper {

	public static PaniersDetailsVo toVo(PaniersDetails paniersDetails) {
        if (paniersDetails == null) return null;

        PaniersDetailsVo vo = new PaniersDetailsVo();
        vo.setArticlesVo(ArticleMapper.toVO(paniersDetails.getArticles()));
        vo.setPaniersVo(PanierMapper.toVO_Simple(paniersDetails.getPaniers()));

        return vo;
    }

    public static PaniersDetails toEntity(PaniersDetailsVo vo) {
        if (vo == null) return null;

        PaniersDetails entity = new PaniersDetails();
        entity.setArticles(ArticleMapper.toEntity(vo.getArticlesVo()));
        entity.setPaniers(PanierMapper.toEntityRef(vo.getPaniersVo()));

        return entity;
    }

    public static void updateEntityFromVo(PaniersDetails entity, PaniersDetailsVo vo) {
        if (entity == null || vo == null) return;

        entity.setArticles(ArticleMapper.toEntity(vo.getArticlesVo()));
        entity.setPaniers(PanierMapper.toEntityRef(vo.getPaniersVo()));
    }
}
