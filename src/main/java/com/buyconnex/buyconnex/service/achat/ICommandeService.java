package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.entity.client.Clients;

public interface ICommandeService {

	public Optional<Commandes> findById(Long id);
	public Commandes saveCommandes(Commandes commandes);
	public void deleteCommandes(Commandes commandes);
	public Commandes updateCommandes(Commandes commandes);
	public Commandes findByNumeroCommande(String numeroCommande);
	public List<Commandes> findByClients(Clients clients);
	public List<Commandes> findByDateCommande(Date date);
	public List<Commandes> findByStatusCommandes(StatusCommandes statusCommandes);
	public List<Commandes> findBymoyensLivraisons(MoyensLivraisons moyensLivraisons);
}
