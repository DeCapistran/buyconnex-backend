package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.entity.achat.StatusPaiements;
import com.buyconnex.buyconnex.repository.achat.PaiementRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaiementService implements IPaiementService{

	@Autowired
	PaiementRepository paiementRepository;
	
	@Override
	public Optional<Paiements> findById(Long id) {
		return paiementRepository.findById(id);
	}

	@Override
	public Paiements savePaiements(Paiements paiements) {
		return paiementRepository.save(paiements);
	}

	@Override
	public void deletePaiements(Paiements paiements) {
		paiementRepository.delete(paiements);
	}

	@Override
	public Paiements updatePaiements(Paiements paiements) {
		return paiementRepository.save(paiements);
	}

	@Override
	public List<Paiements> findByMoyensPaiements(MoyensPaiements moyenPaiement) {
		return paiementRepository.findByMoyensPaiements(moyenPaiement);
	}

	@Override
	public List<Paiements> findByStatusPaiements(StatusPaiements statusPaiements) {
		return paiementRepository.findByStatusPaiements(statusPaiements);
	}

}
