package com.buyconnex.buyconnex.mapper.achat;

import java.util.Set;
import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.LivraisonsDetails;
import com.buyconnex.buyconnex.mapper.client.AdresseMapper;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;

public class LivraisonMapper {

	public static LivraisonsVo toVO(Livraisons livraisons) {
        if (livraisons == null) return null;

        LivraisonsVo vo = new LivraisonsVo();
        vo.setId(livraisons.getLivraison_id());
        vo.setNumeroLivraison(livraisons.getNumeroLivraison());
        vo.setDateLivraisonEstimee(livraisons.getDateLivraisonEstimee());
        vo.setDateLivraison(livraisons.getDateLivraison());
        vo.setCommentaire(livraisons.getCommentaire());

        vo.setStatusLivraisons(StatusLivraisonMapper.toVO_Simple(livraisons.getStatusLivraisons()));
        vo.setAdresses(AdresseMapper.toVO(livraisons.getAdresses()));

        vo.setLivraisonsDetails(
                livraisons.getLivraisonsDetails() == null ? null :
                        livraisons.getLivraisonsDetails().stream()
                                .map(LivraisonDetailMapper::toVO)
                                .collect(Collectors.toSet())
        );

        return vo;
    }

    public static LivraisonsVo toVO_Simple(Livraisons livraisons) {
        if (livraisons == null) return null;

        LivraisonsVo vo = new LivraisonsVo();
        vo.setId(livraisons.getLivraison_id());
        vo.setNumeroLivraison(livraisons.getNumeroLivraison());
        vo.setDateLivraisonEstimee(livraisons.getDateLivraisonEstimee());
        vo.setDateLivraison(livraisons.getDateLivraison());
        vo.setCommentaire(livraisons.getCommentaire());

        vo.setStatusLivraisons(StatusLivraisonMapper.toVO_Simple(livraisons.getStatusLivraisons()));
        vo.setAdresses(AdresseMapper.toVO(livraisons.getAdresses()));

        vo.setLivraisonsDetails(null);
        return vo;
    }

    public static Livraisons toEntityRef(LivraisonsVo vo) {
        if (vo == null || vo.getId() == null) return null;
        Livraisons ref = new Livraisons();
        ref.setLivraison_id(vo.getId());
        return ref;
    }

    public static Livraisons toEntity(LivraisonsVo vo) {
        if (vo == null) return null;

        Livraisons entity = new Livraisons();
        entity.setLivraison_id(vo.getId());
        entity.setNumeroLivraison(vo.getNumeroLivraison());
        entity.setDateLivraisonEstimee(vo.getDateLivraisonEstimee());
        entity.setDateLivraison(vo.getDateLivraison());
        entity.setCommentaire(vo.getCommentaire());

        entity.setStatusLivraisons(StatusLivraisonMapper.toEntityRef(vo.getStatusLivraisons()));
        entity.setAdresses(AdresseMapper.toEntity(vo.getAdresses()));

        if (vo.getLivraisonsDetails() != null) {
            Set<LivraisonsDetails> details = vo.getLivraisonsDetails().stream()
                    .map(LivraisonDetailMapper::toEntity)
                    .collect(Collectors.toSet());

            details.forEach(d -> d.setLivraisons(entity));
            entity.setLivraisonsDetails(details);
        } else {
            entity.setLivraisonsDetails(null);
        }

        return entity;
    }

    public static void updateEntityFromVO(LivraisonsVo vo, Livraisons entity) {
        if (vo == null || entity == null) return;

        entity.setLivraison_id(vo.getId());
        entity.setNumeroLivraison(vo.getNumeroLivraison());
        entity.setDateLivraisonEstimee(vo.getDateLivraisonEstimee());
        entity.setDateLivraison(vo.getDateLivraison());
        entity.setCommentaire(vo.getCommentaire());

        entity.setStatusLivraisons(StatusLivraisonMapper.toEntityRef(vo.getStatusLivraisons()));
        entity.setAdresses(AdresseMapper.toEntity(vo.getAdresses()));

        if (vo.getLivraisonsDetails() != null) {
            Set<LivraisonsDetails> details = vo.getLivraisonsDetails().stream()
                    .map(LivraisonDetailMapper::toEntity)
                    .collect(Collectors.toSet());
            details.forEach(d -> d.setLivraisons(entity));
            entity.setLivraisonsDetails(details);
        } else {
            entity.setLivraisonsDetails(null);
        }
    }
}
