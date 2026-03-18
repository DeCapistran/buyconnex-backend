package com.buyconnex.buyconnex.repository.achat;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.entity.client.Clients;


public interface CommandeRepository extends JpaRepository<Commandes, Long> {

	Commandes findByNumeroCommande(String numCommande);
	List<Commandes> findByClients(Clients client);
	List<Commandes> findByDateCommande(Date date);
	List<Commandes> findByStatusCommandes(StatusCommandes statusCommandes);
	List<Commandes> findByMoyensLivraisons(MoyensLivraisons moyensLivraisons);
}
