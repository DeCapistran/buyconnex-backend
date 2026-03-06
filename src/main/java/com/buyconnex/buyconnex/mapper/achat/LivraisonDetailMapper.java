package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.LivraisonsDetails;
import com.buyconnex.buyconnex.vo.achat.LivraisonsDetailsVo;

public class LivraisonDetailMapper {

	public static LivraisonsDetailsVo toVO(LivraisonsDetails livraisonsDetails) {
        if (livraisonsDetails == null) return null;

        LivraisonsDetailsVo vo = new LivraisonsDetailsVo();

        vo.setLivraisonsVo(LivraisonMapper.toVO_Simple(livraisonsDetails.getLivraisons()));

        vo.setIdCommande(
                livraisonsDetails.getCommandes() != null ? livraisonsDetails.getCommandes().getCommande_id() : null
        );

        return vo;
    }

    public static LivraisonsDetails toEntity(LivraisonsDetailsVo vo) {
        if (vo == null) return null;

        LivraisonsDetails entity = new LivraisonsDetails();

        entity.setLivraisons(LivraisonMapper.toEntityRef(vo.getLivraisonsVo()));

        if (vo.getIdCommande() != null) {
            Commandes cmd = new Commandes();
            cmd.setCommande_id(vo.getIdCommande());
            entity.setCommandes(cmd);
        } else {
            entity.setCommandes(null);
        }

        return entity;
    }

    public static void updateEntityFromVo(LivraisonsDetails entity, LivraisonsDetailsVo vo) {
        if (entity == null || vo == null) return;

        entity.setLivraisons(LivraisonMapper.toEntityRef(vo.getLivraisonsVo()));

        if (vo.getIdCommande() != null) {
            Commandes cmd = new Commandes();
            cmd.setCommande_id(vo.getIdCommande());
            entity.setCommandes(cmd);
        } else {
            entity.setCommandes(null);
        }
    }
}
