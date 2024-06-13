package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.repository.achat.CommandeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommandeService implements ICommandeService {
	
	@Autowired
	CommandeRepository commandeRepository;

	@Override
	public Optional<Commandes> findById(Long id) {
		return commandeRepository.findById(id);
	}
	
	@Override
	public Commandes saveCommandes(Commandes commande) {
		return commandeRepository.save(commande);
	}
	
	@Override
	public void deleteCommandes(Commandes commande) {
		commandeRepository.delete(commande);
	}
	
	@Override
	public Commandes updateCommandes(Commandes commande) {
		return commandeRepository.save(commande);
	}

	@Override
	public Commandes findByNumeroCommande(String numeroCommande) {
		return commandeRepository.findByNumeroCommande(numeroCommande);
	}

	@Override
	public List<Commandes> findByClients(Clients clients) {
		return commandeRepository.findByClients(clients);
	}

	@Override
	public List<Commandes> findByDateCommande(Date date) {
		return commandeRepository.findByDateCommande(date);
	}

	@Override
	public List<Commandes> findByStatusCommandes(StatusCommandes statusCommandes) {
		return commandeRepository.findByStatusCommandes(statusCommandes);
	}

	@Override
	public List<Commandes> findBymoyensLivraisons(MoyensLivraisons moyensLivraisons) {
		return commandeRepository.findByMoyensLivraisons(moyensLivraisons);
	}
	
}
