package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.repository.client.ClientRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClientService implements IClientService {

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Optional<Clients> findById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Clients saveClients(Clients clients) {
		return clientRepository.save(clients);
	}

	@Override
	public void deleteClients(Clients clients) {
		clientRepository.delete(clients);
	}

	@Override
	public Clients updateClients(Clients clients) {
		return clientRepository.save(clients);
	}

	@Override
	public List<Clients> findByadresses(Adresses adresses) {
		return clientRepository.findByAdresses(adresses);
	}

	@Override
	public List<Clients> findByCommandes(Commandes commandes) {
		return clientRepository.findByCommandes(commandes);
	}

	@Override
	public Optional<Clients> findByEntreprises(String entreprise) {
		return clientRepository.findByEntreprise(entreprise);
	}

	@Override
	public List<Clients> findByFirstname(String firstname) {
		return clientRepository.findByFristname(firstname);
	}

	@Override
	public List<Clients> findByLastname(String lastname) {
		return clientRepository.findByLastname(lastname);
	}

	@Override
	public Optional<Clients> findByUsers(Users users) {
		return clientRepository.findByUsers(users);
	}

}
