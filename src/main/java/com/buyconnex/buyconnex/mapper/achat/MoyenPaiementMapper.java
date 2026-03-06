package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.vo.achat.MoyensPaiementsVo;

public class MoyenPaiementMapper {

	public static MoyensPaiementsVo toVO(MoyensPaiements moyensPaiements) {
        if (moyensPaiements == null) return null;

        MoyensPaiementsVo vo = new MoyensPaiementsVo();
        vo.setId(moyensPaiements.getMoyen_paiement_id());
        vo.setMoyensPaiements(moyensPaiements.getMoyenPaiement());
        vo.setDescription(moyensPaiements.getDescription());

        // IMPORTANT
        vo.setPaiements(null);

        return vo;
    }

    public static MoyensPaiementsVo toVO_Simple(MoyensPaiements moyensPaiements) {
        return toVO(moyensPaiements);
    }

    public static MoyensPaiements toEntityRef(MoyensPaiementsVo vo) {
        if (vo == null || vo.getId() == null) return null;
        MoyensPaiements ref = new MoyensPaiements();
        ref.setMoyen_paiement_id(vo.getId());
        return ref;
    }

    public static MoyensPaiements toEntity(MoyensPaiementsVo vo) {
        if (vo == null) return null;

        MoyensPaiements entity = new MoyensPaiements();
        entity.setMoyen_paiement_id(vo.getId());
        entity.setMoyenPaiement(vo.getMoyensPaiements());
        entity.setDescription(vo.getDescription());

        entity.setPaiements(null);
        return entity;
    }

    public static void updateEntityFromVO(MoyensPaiementsVo vo, MoyensPaiements entity) {
        if (vo == null || entity == null) return;

        entity.setMoyen_paiement_id(vo.getId());
        entity.setMoyenPaiement(vo.getMoyensPaiements());
        entity.setDescription(vo.getDescription());

        entity.setPaiements(null);
    }
}
