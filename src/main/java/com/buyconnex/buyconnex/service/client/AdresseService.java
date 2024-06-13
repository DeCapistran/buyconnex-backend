package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.entity.client.Clients;
import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.repository.client.AdresseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdresseService implements IAdresseService {

	@Autowired
	AdresseRepository adresseRepository;
	
	@Override
	public Optional<Adresses> findById(Long id) {
		return adresseRepository.findById(id);
	}

	@Override
	public Adresses saveAdresse(Adresses adresses) {
		return adresseRepository.save(adresses);
	}

	@Override
	public void deleteAdresse(Adresses adresses) {
		adresseRepository.delete(adresses);
	}

	@Override
	public Adresses updateAdresse(Adresses adresses) {
		return adresseRepository.save(adresses);
	}

	@Override
	public List<Adresses> findByFacturations(Facturations facturations) {
		return adresseRepository.findByFacturations(facturations);
	}

	@Override
	public List<Adresses> findByLivraisons(Livraisons livraisons) {
		return adresseRepository.findByLivraisons(livraisons);
	}

	@Override
	public List<Adresses> findByPays(Pays pays) {
		return adresseRepository.findByPays(pays);
	}

	@Override
	public List<Adresses> findByVilles(Villes villes) {
		return adresseRepository.findByVille(villes);
	}

	@Override
	public List<Adresses> findByClients(Clients clients) {
		return adresseRepository.findByClients(clients);
	}

}
