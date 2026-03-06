package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.StatusPaiements;
import com.buyconnex.buyconnex.vo.achat.StatusPaiementsVo;

public class StatusPaiementMapper {

	public static StatusPaiementsVo toVO(StatusPaiements statusPaiements) {
        if (statusPaiements == null) return null;

        StatusPaiementsVo vo = new StatusPaiementsVo();
        vo.setId(statusPaiements.getStatus_paiement_id());
        vo.setDescription(statusPaiements.getDescription());
        vo.setStatus(statusPaiements.getStatus());

        // IMPORTANT
        vo.setPaiements(null);

        return vo;
    }

    public static StatusPaiementsVo toVO_Simple(StatusPaiements statusPaiements) {
        return toVO(statusPaiements);
    }

    public static StatusPaiements toEntityRef(StatusPaiementsVo vo) {
        if (vo == null || vo.getId() == null) return null;
        StatusPaiements ref = new StatusPaiements();
        ref.setStatus_paiement_id(vo.getId());
        return ref;
    }

    public static StatusPaiements toEntity(StatusPaiementsVo vo) {
        if (vo == null) return null;

        StatusPaiements entity = new StatusPaiements();
        entity.setStatus_paiement_id(vo.getId());
        entity.setDescription(vo.getDescription());
        entity.setStatus(vo.getStatus());

        entity.setPaiements(null);
        return entity;
    }

    public static void updateEntityFromVO(StatusPaiementsVo vo, StatusPaiements entity) {
        if (vo == null || entity == null) return;

        entity.setStatus_paiement_id(vo.getId());
        entity.setDescription(vo.getDescription());
        entity.setStatus(vo.getStatus());

        entity.setPaiements(null);
    }
}
