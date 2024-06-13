package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.repository.achat.LivraisonRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LivraisonService implements ILivraisonService {

	@Autowired
	LivraisonRepository livraisonRepository;
	
	@Override
	public Optional<Livraisons> findById(Long id) {
		return livraisonRepository.findById(id);
	}

	@Override
	public Livraisons saveLivraisons(Livraisons livraisons) {
		return livraisonRepository.save(livraisons);
	}

	@Override
	public void deleteLivraisons(Livraisons livraisons) {
		livraisonRepository.delete(livraisons);
	}

	@Override
	public Livraisons updateLivraisons(Livraisons livraisons) {
		return livraisonRepository.save(livraisons);
	}

	@Override
	public List<Livraisons> findByCommandes(Commandes commandes) {
		return livraisonRepository.findByCommandes(commandes);
	}

	@Override
	public List<Livraisons> findByAdresses(Adresses adresses) {
		return livraisonRepository.findByAdresses(adresses);
	}

	@Override
	public List<Livraisons> findByDateLivraisons(Date date) {
		return livraisonRepository.findByDateLivraison(date);
	}

	@Override
	public Livraisons findByNumeroLivraisons(String numeroLivraison) {
		return livraisonRepository.findByNumeroLivraison(numeroLivraison);
	}

	@Override
	public List<Livraisons> findByStatusLivraisons(StatusLivraisons statusLivraisons) {
		return livraisonRepository.findByStatusLivraisons(statusLivraisons);
	}

}
