package com.buyconnex.buyconnex.mapper.client;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.client.ClientsVo;

public class ClientMapper {
	
	public static ClientsVo toVO(Clients clients) {
		ClientsVo clientsVo = new ClientsVo();
		clientsVo.setId(clients.getClient_id());
		clientsVo.setFirstname(clients.getFristname());
		clientsVo.setLastname(clients.getLastname());
		clientsVo.setEntreprise(clients.getEntreprise());
		clientsVo.setGenre(clients.getGenre());
		clientsVo.setFacebook(clients.getFacebook());
		clientsVo.setInstagram(clients.getInstagram());
		clientsVo.setTelephone1(clients.getTelephone1());
		clientsVo.setTelephone2(clients.getTelephone2());
		clientsVo.setAdresses(AdresseMapper.toVO(clients.getAdresses()));
		clientsVo.setUsers(UserMapper.toVO(clients.getUsers()));
		clientsVo.setCommandes(clients.getCommandes().stream().map(CommandeMapper::toVO).collect(Collectors.toSet()));
		
		return clientsVo;	
	}
	
	public static Clients toEntity(ClientsVo clientsVo) {
		Clients clients = new Clients();
		clients.setClient_id(clientsVo.getId());
		clients.setFristname(clientsVo.getFirstname());
		clients.setLastname(clientsVo.getLastname());
		clients.setEntreprise(clientsVo.getEntreprise());
		clients.setGenre(clientsVo.getGenre());
		clients.setFacebook(clientsVo.getFacebook());
		clients.setInstagram(clientsVo.getInstagram());
		clients.setTelephone1(clientsVo.getTelephone1());
		clients.setTelephone2(clientsVo.getTelephone2());
		clients.setAdresses(AdresseMapper.toEntity(clientsVo.getAdresses()));
		clients.setUsers(UserMapper.toEntity(clientsVo.getUsers()));
		clients.setCommandes(clientsVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		
		return clients;	
	}
	
	public static void updateEntityFromVO(ClientsVo clientsVo, Clients clients) {
		clients.setClient_id(clientsVo.getId());
		clients.setFristname(clientsVo.getFirstname());
		clients.setLastname(clientsVo.getLastname());
		clients.setEntreprise(clientsVo.getEntreprise());
		clients.setGenre(clientsVo.getGenre());
		clients.setFacebook(clientsVo.getFacebook());
		clients.setInstagram(clientsVo.getInstagram());
		clients.setTelephone1(clientsVo.getTelephone1());
		clients.setTelephone2(clientsVo.getTelephone2());
		clients.setAdresses(AdresseMapper.toEntity(clientsVo.getAdresses()));
		clients.setUsers(UserMapper.toEntity(clientsVo.getUsers()));
		clients.setCommandes(clientsVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		
	}

}
