package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;

public class StatusCommandeMapper {

	public static StatusCommandesVo toVO(StatusCommandes statusCommandes) {
        if (statusCommandes == null) return null;

        StatusCommandesVo vo = new StatusCommandesVo();
        vo.setId(statusCommandes.getStatus_commande_id());
        vo.setDescription(statusCommandes.getDescription());
        vo.setStatus(statusCommandes.getStatus());

        // IMPORTANT : casser les cycles + éviter des graphes énormes
        vo.setCommandes(null);

        return vo;
    }

    /** Mapping simple (identique ici) */
    public static StatusCommandesVo toVO_Simple(StatusCommandes statusCommandes) {
        return toVO(statusCommandes);
    }

    /** Référence (id uniquement) */
    public static StatusCommandes toEntityRef(StatusCommandesVo vo) {
        if (vo == null || vo.getId() == null) return null;
        StatusCommandes ref = new StatusCommandes();
        ref.setStatus_commande_id(vo.getId());
        return ref;
    }

    /** toEntity : ne reconstruit pas le graphe */
    public static StatusCommandes toEntity(StatusCommandesVo vo) {
        if (vo == null) return null;

        StatusCommandes entity = new StatusCommandes();
        entity.setStatus_commande_id(vo.getId());
        entity.setDescription(vo.getDescription());
        entity.setStatus(vo.getStatus());

        entity.setCommandes(null);
        return entity;
    }

    public static void updateEntityFromVO(StatusCommandesVo vo, StatusCommandes entity) {
        if (vo == null || entity == null) return;

        entity.setStatus_commande_id(vo.getId());
        entity.setDescription(vo.getDescription());
        entity.setStatus(vo.getStatus());

        entity.setCommandes(null);
    }
}
