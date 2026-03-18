package com.buyconnex.buyconnex.mapper.client;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.client.ClientsVo;

public class ClientMapper {
	
	public static ClientsVo toVO(Clients clients) {
        if (clients == null) return null;

        ClientsVo vo = new ClientsVo();
        vo.setId(clients.getClient_id());
        vo.setFirstname(clients.getFristname());
        vo.setLastname(clients.getLastname());
        vo.setEntreprise(clients.getEntreprise());
        vo.setGenre(clients.getGenre());
        vo.setFacebook(clients.getFacebook());
        vo.setInstagram(clients.getInstagram());
        vo.setTelephone1(clients.getTelephone1());
        vo.setTelephone2(clients.getTelephone2());
        vo.setAdresses(AdresseMapper.toVO(clients.getAdresses()));
        vo.setUsers(UserMapper.toVO(clients.getUsers()));

        // IMPORTANT : commandes en SIMPLE (contrôle du graphe)
        vo.setCommandes(
                clients.getCommandes() == null ? null :
                        clients.getCommandes().stream()
                                .map(CommandeMapper::toVO_Simple)
                                .collect(Collectors.toSet())
        );

        return vo;
    }

    /**
     * Version sans commandes : à utiliser côté CommandeMapper pour éviter toute récursion.
     */
    public static ClientsVo toVO_NoCommandes(Clients clients) {
        if (clients == null) return null;

        ClientsVo vo = new ClientsVo();
        vo.setId(clients.getClient_id());
        vo.setFirstname(clients.getFristname());
        vo.setLastname(clients.getLastname());
        vo.setEntreprise(clients.getEntreprise());
        vo.setGenre(clients.getGenre());
        vo.setFacebook(clients.getFacebook());
        vo.setInstagram(clients.getInstagram());
        vo.setTelephone1(clients.getTelephone1());
        vo.setTelephone2(clients.getTelephone2());
        vo.setAdresses(AdresseMapper.toVO(clients.getAdresses()));
        vo.setUsers(UserMapper.toVO(clients.getUsers()));

        vo.setCommandes(null);
        return vo;
    }

    /** Référence (id only) */
    public static Clients toEntityRef(ClientsVo vo) {
        if (vo == null || vo.getId() == null) return null;
        Clients ref = new Clients();
        ref.setClient_id(vo.getId());
        return ref;
    }

    public static Clients toEntity(ClientsVo vo) {
        if (vo == null) return null;

        Clients entity = new Clients();
        entity.setClient_id(vo.getId());
        entity.setFristname(vo.getFirstname());
        entity.setLastname(vo.getLastname());
        entity.setEntreprise(vo.getEntreprise());
        entity.setGenre(vo.getGenre());
        entity.setFacebook(vo.getFacebook());
        entity.setInstagram(vo.getInstagram());
        entity.setTelephone1(vo.getTelephone1());
        entity.setTelephone2(vo.getTelephone2());

        // Adresse en référence (id only)
        if (vo.getAdresses() != null && vo.getAdresses().getId() != null) {
            Adresses adresse = new Adresses();
            adresse.setAdresse_id(vo.getAdresses().getId());
            entity.setAdresses(adresse);
        } else {
            entity.setAdresses(null);
        }

        // User en référence (id only)
        if (vo.getUsers() != null && vo.getUsers().getId() != null) {
            Users user = new Users();
            user.setUser_id(vo.getUsers().getId());
            entity.setUsers(user);
        } else {
            entity.setUsers(null);
        }

        // IMPORTANT : ne pas reconstruire les commandes ici (service dédié si besoin)
        entity.setCommandes(null);

        return entity;
    }

    public static void updateEntityFromVO(ClientsVo vo, Clients entity) {
        if (vo == null || entity == null) return;

        entity.setClient_id(vo.getId());
        entity.setFristname(vo.getFirstname());
        entity.setLastname(vo.getLastname());
        entity.setEntreprise(vo.getEntreprise());
        entity.setGenre(vo.getGenre());
        entity.setFacebook(vo.getFacebook());
        entity.setInstagram(vo.getInstagram());
        entity.setTelephone1(vo.getTelephone1());
        entity.setTelephone2(vo.getTelephone2());

        if (vo.getAdresses() != null && vo.getAdresses().getId() != null) {
            Adresses adresse = new Adresses();
            adresse.setAdresse_id(vo.getAdresses().getId());
            entity.setAdresses(adresse);
        } else {
            entity.setAdresses(null);
        }

        if (vo.getUsers() != null && vo.getUsers().getId() != null) {
            Users user = new Users();
            user.setUser_id(vo.getUsers().getId());
            entity.setUsers(user);
        } else {
            entity.setUsers(null);
        }

        entity.setCommandes(null);
    }
}
