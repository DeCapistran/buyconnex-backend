package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.vo.achat.StatusLivraisonsVo;

public class StatusLivraisonMapper {

	public static StatusLivraisonsVo toVO(StatusLivraisons statusLivraisons) {
        if (statusLivraisons == null) return null;

        StatusLivraisonsVo vo = new StatusLivraisonsVo();
        vo.setId(statusLivraisons.getStatus_livraison_id());
        vo.setDescription(statusLivraisons.getDescription());
        vo.setStatus(statusLivraisons.getStatus());

        // IMPORTANT
        vo.setLivraisons(null);

        return vo;
    }

    public static StatusLivraisonsVo toVO_Simple(StatusLivraisons statusLivraisons) {
        return toVO(statusLivraisons);
    }

    public static StatusLivraisons toEntityRef(StatusLivraisonsVo vo) {
        if (vo == null || vo.getId() == null) return null;
        StatusLivraisons ref = new StatusLivraisons();
        ref.setStatus_livraison_id(vo.getId());
        return ref;
    }

    public static StatusLivraisons toEntity(StatusLivraisonsVo vo) {
        if (vo == null) return null;

        StatusLivraisons entity = new StatusLivraisons();
        entity.setStatus_livraison_id(vo.getId());
        entity.setDescription(vo.getDescription());
        entity.setStatus(vo.getStatus());

        entity.setLivraisons(null);
        return entity;
    }

    public static void updateEntityFromVO(StatusLivraisonsVo vo, StatusLivraisons entity) {
        if (vo == null || entity == null) return;

        entity.setStatus_livraison_id(vo.getId());
        entity.setDescription(vo.getDescription());
        entity.setStatus(vo.getStatus());

        entity.setLivraisons(null);
    }
}
