package com.buyconnex.buyconnex.mapper.achat;

import java.util.Set;
import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.CommandesDetails;
import com.buyconnex.buyconnex.entity.achat.Expeditions;
import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.entity.achat.LivraisonsDetails;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.mapper.client.ClientMapper;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;

public class CommandeMapper {

	public static CommandesVo toVO(Commandes commandes) {
        if (commandes == null) return null;

        CommandesVo vo = new CommandesVo();
        vo.setId(commandes.getCommande_id());
        vo.setNumeroCommande(commandes.getNumeroCommande());
        vo.setDateCommande(commandes.getDateCommande());
        vo.setCodeCoupon(commandes.getCodeCoupon());

        vo.setClients(ClientMapper.toVO_NoCommandes(commandes.getClients()));

        vo.setStatusCommandes(StatusCommandeMapper.toVO_Simple(commandes.getStatusCommandes()));
        vo.setMoyensLivraisons(MoyenLivraisonMapper.toVO_Simple(commandes.getMoyensLivraisons()));

        vo.setExpeditions(
                commandes.getExpeditions() == null ? null :
                        commandes.getExpeditions().stream()
                                .map(ExpeditionMapper::toVO)
                                .collect(Collectors.toSet())
        );

        vo.setFacturations(
                commandes.getFacturations() == null ? null :
                        commandes.getFacturations().stream()
                                .map(FacturationMapper::toVO)
                                .collect(Collectors.toSet())
        );

        vo.setCommandesDetails(
                commandes.getCommandesDetails() == null ? null :
                        commandes.getCommandesDetails().stream()
                                .map(CommandeDetailMapper::toVO)
                                .collect(Collectors.toSet())
        );

        vo.setLivraisonsDetails(
                commandes.getLivraisonsDetails() == null ? null :
                        commandes.getLivraisonsDetails().stream()
                                .map(LivraisonDetailMapper::toVO)
                                .collect(Collectors.toSet())
        );

        return vo;
    }
     
    public static CommandesVo toVO_Simple(Commandes commandes) {
        if (commandes == null) return null;

        CommandesVo vo = new CommandesVo();
        vo.setId(commandes.getCommande_id());
        vo.setNumeroCommande(commandes.getNumeroCommande());
        vo.setDateCommande(commandes.getDateCommande());
        vo.setCodeCoupon(commandes.getCodeCoupon());

        vo.setClients(null);
        vo.setStatusCommandes(StatusCommandeMapper.toVO_Simple(commandes.getStatusCommandes()));
        vo.setMoyensLivraisons(MoyenLivraisonMapper.toVO_Simple(commandes.getMoyensLivraisons()));

        vo.setExpeditions(null);
        vo.setFacturations(null);
        vo.setCommandesDetails(null);
        vo.setLivraisonsDetails(null);

        return vo;
    }

    /** Référence (id uniquement) */
    public static Commandes toEntityRef(CommandesVo vo) {
        if (vo == null || vo.getId() == null) return null;
        Commandes ref = new Commandes();
        ref.setCommande_id(vo.getId());
        return ref;
    }

    public static Commandes toEntity(CommandesVo vo) {
        if (vo == null) return null;

        Commandes entity = new Commandes();
        entity.setCommande_id(vo.getId());
        entity.setNumeroCommande(vo.getNumeroCommande());
        entity.setDateCommande(vo.getDateCommande());
        entity.setCodeCoupon(vo.getCodeCoupon());

        if (vo.getClients() != null && vo.getClients().getId() != null) {
            Clients c = new Clients();
            c.setClient_id(vo.getClients().getId());
            entity.setClients(c);
        } else {
            entity.setClients(null);
        }

        entity.setStatusCommandes(StatusCommandeMapper.toEntityRef(vo.getStatusCommandes()));
        entity.setMoyensLivraisons(MoyenLivraisonMapper.toEntityRef(vo.getMoyensLivraisons()));

        if (vo.getExpeditions() != null) {
            Set<Expeditions> exps = vo.getExpeditions().stream()
                    .map(ExpeditionMapper::toEntity)
                    .collect(Collectors.toSet());
            exps.forEach(e -> e.setCommandes(entity));
            entity.setExpeditions(exps);
        } else {
            entity.setExpeditions(null);
        }

        if (vo.getFacturations() != null) {
            Set<Facturations> facts = vo.getFacturations().stream()
                    .map(FacturationMapper::toEntity)
                    .collect(Collectors.toSet());
            facts.forEach(f -> f.setCommandes(entity));
            entity.setFacturations(facts);
        } else {
            entity.setFacturations(null);
        }

        if (vo.getCommandesDetails() != null) {
            Set<CommandesDetails> dets = vo.getCommandesDetails().stream()
                    .map(CommandeDetailMapper::toEntity)
                    .collect(Collectors.toSet());
            dets.forEach(d -> d.setCommandes(entity));
            entity.setCommandesDetails(dets);
        } else {
            entity.setCommandesDetails(null);
        }

        if (vo.getLivraisonsDetails() != null) {
            Set<LivraisonsDetails> lds = vo.getLivraisonsDetails().stream()
                    .map(LivraisonDetailMapper::toEntity)
                    .collect(Collectors.toSet());
            lds.forEach(ld -> ld.setCommandes(entity));
            entity.setLivraisonsDetails(lds);
        } else {
            entity.setLivraisonsDetails(null);
        }

        return entity;
    }

    public static void updateEntityFromVO(CommandesVo vo, Commandes entity) {
        if (vo == null || entity == null) return;

        entity.setCommande_id(vo.getId());
        entity.setNumeroCommande(vo.getNumeroCommande());
        entity.setDateCommande(vo.getDateCommande());
        entity.setCodeCoupon(vo.getCodeCoupon());

        if (vo.getClients() != null && vo.getClients().getId() != null) {
            Clients c = new Clients();
            c.setClient_id(vo.getClients().getId());
            entity.setClients(c);
        } else {
            entity.setClients(null);
        }

        entity.setStatusCommandes(StatusCommandeMapper.toEntityRef(vo.getStatusCommandes()));
        entity.setMoyensLivraisons(MoyenLivraisonMapper.toEntityRef(vo.getMoyensLivraisons()));

        if (vo.getExpeditions() != null) {
            Set<Expeditions> exps = vo.getExpeditions().stream()
                    .map(ExpeditionMapper::toEntity)
                    .collect(Collectors.toSet());
            exps.forEach(e -> e.setCommandes(entity));
            entity.setExpeditions(exps);
        } else {
            entity.setExpeditions(null);
        }

        if (vo.getFacturations() != null) {
            Set<Facturations> facts = vo.getFacturations().stream()
                    .map(FacturationMapper::toEntity)
                    .collect(Collectors.toSet());
            facts.forEach(f -> f.setCommandes(entity));
            entity.setFacturations(facts);
        } else {
            entity.setFacturations(null);
        }

        if (vo.getCommandesDetails() != null) {
            Set<CommandesDetails> dets = vo.getCommandesDetails().stream()
                    .map(CommandeDetailMapper::toEntity)
                    .collect(Collectors.toSet());
            dets.forEach(d -> d.setCommandes(entity));
            entity.setCommandesDetails(dets);
        } else {
            entity.setCommandesDetails(null);
        }

        if (vo.getLivraisonsDetails() != null) {
            Set<LivraisonsDetails> lds = vo.getLivraisonsDetails().stream()
                    .map(LivraisonDetailMapper::toEntity)
                    .collect(Collectors.toSet());
            lds.forEach(ld -> ld.setCommandes(entity));
            entity.setLivraisonsDetails(lds);
        } else {
            entity.setLivraisonsDetails(null);
        }
    }
}