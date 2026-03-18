package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
import com.buyconnex.buyconnex.vo.achat.MoyensLivraisonsVo;

public class MoyenLivraisonMapper {

	public static MoyensLivraisonsVo toVO(MoyensLivraisons moyensLivraisons) {
        if (moyensLivraisons == null) return null;

        MoyensLivraisonsVo vo = new MoyensLivraisonsVo();
        vo.setId(moyensLivraisons.getMoyen_livraison_id());
        vo.setMoyenLivraisons(moyensLivraisons.getMoyenLivraison());
        vo.setDescription(moyensLivraisons.getDescription());

        // IMPORTANT
        vo.setCommandes(null);

        return vo;
    }

    public static MoyensLivraisonsVo toVO_Simple(MoyensLivraisons moyensLivraisons) {
        return toVO(moyensLivraisons);
    }

    public static MoyensLivraisons toEntityRef(MoyensLivraisonsVo vo) {
        if (vo == null || vo.getId() == null) return null;
        MoyensLivraisons ref = new MoyensLivraisons();
        ref.setMoyen_livraison_id(vo.getId());
        return ref;
    }

    public static MoyensLivraisons toEntity(MoyensLivraisonsVo vo) {
        if (vo == null) return null;

        MoyensLivraisons entity = new MoyensLivraisons();
        entity.setMoyen_livraison_id(vo.getId());
        entity.setMoyenLivraison(vo.getMoyenLivraisons());
        entity.setDescription(vo.getDescription());

        entity.setCommandes(null);
        return entity;
    }

    public static void updateEntityFromVO(MoyensLivraisonsVo vo, MoyensLivraisons entity) {
        if (vo == null || entity == null) return;

        entity.setMoyen_livraison_id(vo.getId());
        entity.setMoyenLivraison(vo.getMoyenLivraisons());
        entity.setDescription(vo.getDescription());

        entity.setCommandes(null);
    }
}
