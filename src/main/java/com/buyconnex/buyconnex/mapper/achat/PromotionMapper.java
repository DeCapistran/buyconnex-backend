package com.buyconnex.buyconnex.mapper.achat;

import java.util.Set;
import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.Promotions;
import com.buyconnex.buyconnex.entity.achat.PromotionsDetails;
import com.buyconnex.buyconnex.vo.achat.PromotionsVo;

public class PromotionMapper {

	 public static PromotionsVo toVo(Promotions promotions) {
	        if (promotions == null) return null;

	        PromotionsVo vo = new PromotionsVo();
	        vo.setId(promotions.getPromotion_id());
	        vo.setDateCreation(promotions.getDateCreation());
	        vo.setDateDebut(promotions.getDateDebut());
	        vo.setDateFin(promotions.getDateFin());
	        vo.setPourcentage(promotions.getPourcentage());
	        vo.setLibelle(promotions.getLibelle());
	        vo.setDescription(promotions.getDescription());

	        vo.setPromotionsDetails(
	                promotions.getPromotionsDetails() == null ? null :
	                        promotions.getPromotionsDetails().stream()
	                                .map(PromotionDetailMapper::toVO)
	                                .collect(Collectors.toSet())
	        );

	        return vo;
	    }

	    /** Simple : sans details */
	    public static PromotionsVo toVO_Simple(Promotions promotions) {
	        if (promotions == null) return null;

	        PromotionsVo vo = new PromotionsVo();
	        vo.setId(promotions.getPromotion_id());
	        vo.setDateCreation(promotions.getDateCreation());
	        vo.setDateDebut(promotions.getDateDebut());
	        vo.setDateFin(promotions.getDateFin());
	        vo.setPourcentage(promotions.getPourcentage());
	        vo.setLibelle(promotions.getLibelle());
	        vo.setDescription(promotions.getDescription());

	        vo.setPromotionsDetails(null);
	        return vo;
	    }

	    /** Référence (id only) */
	    public static Promotions toEntityRef(PromotionsVo vo) {
	        if (vo == null || vo.getId() == null) return null;
	        Promotions ref = new Promotions();
	        ref.setPromotion_id(vo.getId());
	        return ref;
	    }

	    public static Promotions toEntity(PromotionsVo vo) {
	        if (vo == null) return null;

	        Promotions entity = new Promotions();
	        entity.setPromotion_id(vo.getId());
	        entity.setDateCreation(vo.getDateCreation());
	        entity.setDateDebut(vo.getDateDebut());
	        entity.setDateFin(vo.getDateFin());
	        entity.setPourcentage(vo.getPourcentage());
	        entity.setLibelle(vo.getLibelle());
	        entity.setDescription(vo.getDescription());

	        if (vo.getPromotionsDetails() != null) {
	            Set<PromotionsDetails> details = vo.getPromotionsDetails().stream()
	                    .map(PromotionDetailMapper::toEntity)
	                    .collect(Collectors.toSet());

	            // IMPORTANT : rattacher le parent
	            details.forEach(d -> d.setPromotions(entity));
	            entity.setPromotionsDetails(details);
	        } else {
	            entity.setPromotionsDetails(null);
	        }

	        return entity;
	    }

	    public static void updateEntityFromVo(Promotions entity, PromotionsVo vo) {
	        if (entity == null || vo == null) return;

	        entity.setPromotion_id(vo.getId());
	        entity.setDateCreation(vo.getDateCreation());
	        entity.setDateDebut(vo.getDateDebut());
	        entity.setDateFin(vo.getDateFin());
	        entity.setPourcentage(vo.getPourcentage());
	        entity.setLibelle(vo.getLibelle());
	        entity.setDescription(vo.getDescription());

	        if (vo.getPromotionsDetails() != null) {
	            Set<PromotionsDetails> details = vo.getPromotionsDetails().stream()
	                    .map(PromotionDetailMapper::toEntity)
	                    .collect(Collectors.toSet());
	            details.forEach(d -> d.setPromotions(entity));
	            entity.setPromotionsDetails(details);
	        } else {
	            entity.setPromotionsDetails(null);
	        }
	    }
}
