package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
import com.buyconnex.buyconnex.repository.achat.MoyenLivraisonRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MoyenLivraisonService implements IMoyenLivraisonService {

	@Autowired
	MoyenLivraisonRepository moyenLivraisonRepository;
	
	@Override
	public Optional<MoyensLivraisons> findByid(Long id) {
		return moyenLivraisonRepository.findById(id);
	}

	@Override
	public MoyensLivraisons saveMoyensLivraisons(MoyensLivraisons moyensLivraisons) {
		return moyenLivraisonRepository.save(moyensLivraisons);
	}

	@Override
	public void deleteMoyensLivraisons(MoyensLivraisons moyensLivraisons) {
		moyenLivraisonRepository.delete(moyensLivraisons);
	}

	@Override
	public MoyensLivraisons updateMoyensLivraisons(MoyensLivraisons moyensLivraisons) {
		return moyenLivraisonRepository.save(moyensLivraisons);
	}

	@Override
	public List<MoyensLivraisons> findByCommandes(Commandes commandes) {
		return moyenLivraisonRepository.findByCommandes(commandes);
	}

	@Override
	public List<MoyensLivraisons> findByMoyensLivraisons(String moyenLivraison) {
		return moyenLivraisonRepository.findByMoyenLivraison(moyenLivraison);
	}

}
