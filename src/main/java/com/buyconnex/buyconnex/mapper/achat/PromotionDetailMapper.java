package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.PromotionsDetails;
import com.buyconnex.buyconnex.mapper.article.ArticleMapper;
import com.buyconnex.buyconnex.vo.achat.PromotionsDetailsVo;

public class PromotionDetailMapper {

	public static PromotionsDetailsVo toVO(PromotionsDetails promotionsDetails) {
        if (promotionsDetails == null) return null;

        PromotionsDetailsVo vo = new PromotionsDetailsVo();
        vo.setArticlesVo(ArticleMapper.toVO(promotionsDetails.getArticles()));
        vo.setPromotionsVo(PromotionMapper.toVO_Simple(promotionsDetails.getPromotions()));

        return vo;
    }

    public static PromotionsDetails toEntity(PromotionsDetailsVo vo) {
        if (vo == null) return null;

        PromotionsDetails entity = new PromotionsDetails();
        entity.setArticles(ArticleMapper.toEntity(vo.getArticlesVo()));
        entity.setPromotions(PromotionMapper.toEntityRef(vo.getPromotionsVo()));

        return entity;
    }

    public static void updateEntityFromVo(PromotionsDetails entity, PromotionsDetailsVo vo) {
        if (entity == null || vo == null) return;

        entity.setArticles(ArticleMapper.toEntity(vo.getArticlesVo()));
        entity.setPromotions(PromotionMapper.toEntityRef(vo.getPromotionsVo()));
    }
}
