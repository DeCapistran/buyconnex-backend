package com.buyconnex.buyconnex.repository.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;



public interface AdresseRepository extends JpaRepository<Adresses, Long> {

	List<Adresses> findByFacturations(Facturations facturations);
	List<Adresses> findByLivraisons(Livraisons livraisons);
	List<Adresses> findByPays(Pays pays);
	List<Adresses> findByVille(Villes ville);
	List<Adresses> findByClients(Clients clients);
	boolean existByAdresse(String adresse);
}
