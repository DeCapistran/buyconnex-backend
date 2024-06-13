package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;

public interface IAdresseService {
	
	public Optional<Adresses> findById(Long id);
	public Adresses saveAdresse(Adresses adresses);
	public void deleteAdresse(Adresses adresses);
	public Adresses updateAdresse(Adresses adresses);
	public List<Adresses> findByFacturations(Facturations facturations);
	public List<Adresses> findByLivraisons(Livraisons livraisons);
	public List<Adresses> findByPays(Pays pays);
	public List<Adresses> findByVilles(Villes villes);
	public List<Adresses> findByClients(Clients clients);
	
}
