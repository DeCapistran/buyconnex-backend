package com.buyconnex.buyconnex.service.client;

import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.user.Users;

public interface IClientService {

	public Clients findById(Long id);
	public Clients saveClients(Clients clients);
	public void deleteClients(Clients clients);
	public Clients updateClients(Clients clients);
	public List<Clients> findByadresses(Adresses adresses);
	public List<Clients> findByCommandes(Commandes commandes);
	public List<Clients> findByEntreprises(String entreprise);
	public List<Clients> findByFirstname(String firstname);
	public List<Clients> findByLastname(String lastname);
	public List<Clients> findByUsers(Users users);
}
