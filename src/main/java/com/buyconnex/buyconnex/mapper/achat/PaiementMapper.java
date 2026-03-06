package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;

public class PaiementMapper {

	public static PaiementsVo toVO(Paiements paiements) {
        if (paiements == null) return null;

        PaiementsVo vo = new PaiementsVo();
        vo.setId(paiements.getPaiement_id());
        vo.setDatePaiement(paiements.getDatePaiement());
        vo.setMontant(paiements.getMontant());

        vo.setMoyensPaiements(MoyenPaiementMapper.toVO_Simple(paiements.getMoyensPaiements()));
        vo.setStatusPaiements(StatusPaiementMapper.toVO_Simple(paiements.getStatusPaiements()));

        return vo;
    }

    public static Paiements toEntity(PaiementsVo vo) {
        if (vo == null) return null;

        Paiements entity = new Paiements();
        entity.setPaiement_id(vo.getId());
        entity.setDatePaiement(vo.getDatePaiement());
        entity.setMontant(vo.getMontant());

        entity.setMoyensPaiements(MoyenPaiementMapper.toEntityRef(vo.getMoyensPaiements()));
        entity.setStatusPaiements(StatusPaiementMapper.toEntityRef(vo.getStatusPaiements()));

        return entity;
    }

    public static void updateEntityFromVO(PaiementsVo vo, Paiements entity) {
        if (vo == null || entity == null) return;

        entity.setPaiement_id(vo.getId());
        entity.setDatePaiement(vo.getDatePaiement());
        entity.setMontant(vo.getMontant());

        entity.setMoyensPaiements(MoyenPaiementMapper.toEntityRef(vo.getMoyensPaiements()));
        entity.setStatusPaiements(StatusPaiementMapper.toEntityRef(vo.getStatusPaiements()));
    }
}
