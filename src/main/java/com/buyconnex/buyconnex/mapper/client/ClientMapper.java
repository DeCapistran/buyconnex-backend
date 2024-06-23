package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.vo.client.ClientsVo;

public class ClientMapper {
	
	public static ClientsVo toVO(Clients clients) {
		ClientsVo clientsVo = new ClientsVo();
		clientsVo.setFirstname(clients.getFristname());
		clientsVo.setLastname(clients.getLastname());
		clientsVo.setEntreprise(clients.getEntreprise());
		clientsVo.setGenre(clients.getGenre());
		clientsVo.setFacebook(clients.getFacebook());
		clientsVo.setInstagram(clients.getInstagram());
		clientsVo.setTelephone1(clients.getTelephone1());
		clientsVo.setTelephone2(clients.getTelephone2());
		clientsVo.setAdresses(clients.getAdresses());
		clientsVo.setUsers(clients.getUsers());
		clientsVo.setCommandes(clients.getCommandes());
		
		return clientsVo;	
	}
	
	public static Clients toEntity(ClientsVo clientsVo) {
		Clients clients = new Clients();
		clients.setFristname(clientsVo.getFirstname());
		clients.setLastname(clientsVo.getLastname());
		clients.setEntreprise(clientsVo.getEntreprise());
		clients.setGenre(clientsVo.getGenre());
		clients.setFacebook(clientsVo.getFacebook());
		clients.setInstagram(clientsVo.getInstagram());
		clients.setTelephone1(clientsVo.getTelephone1());
		clients.setTelephone2(clientsVo.getTelephone2());
		clients.setAdresses(clientsVo.getAdresses());
		clients.setUsers(clientsVo.getUsers());
		clients.setCommandes(clientsVo.getCommandes());
		
		return clients;	
	}
	
	public static void updateEntityFromVO(ClientsVo clientsVo, Clients clients) {
		
		clients.setFristname(clientsVo.getFirstname());
		clients.setLastname(clientsVo.getLastname());
		clients.setEntreprise(clientsVo.getEntreprise());
		clients.setGenre(clientsVo.getGenre());
		clients.setFacebook(clientsVo.getFacebook());
		clients.setInstagram(clientsVo.getInstagram());
		clients.setTelephone1(clientsVo.getTelephone1());
		clients.setTelephone2(clientsVo.getTelephone2());
		clients.setAdresses(clientsVo.getAdresses());
		clients.setUsers(clientsVo.getUsers());
		clients.setCommandes(clientsVo.getCommandes());
	}

}
