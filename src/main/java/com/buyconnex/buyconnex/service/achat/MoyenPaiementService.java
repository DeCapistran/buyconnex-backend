package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.repository.achat.MoyenPaiementRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MoyenPaiementService implements IMoyenPaiementService {

	MoyenPaiementRepository moyenPaiementRepository;
	
	@Override
	public Optional<MoyensPaiements> findById(Long id) {
		return moyenPaiementRepository.findById(id);
	}

	@Override
	public MoyensPaiements saveMoyensPaiements(MoyensPaiements moyensPaiements) {
		return moyenPaiementRepository.save(moyensPaiements);
	}

	@Override
	public void deleteMoyensPaiements(MoyensPaiements moyensPaiements) {
		moyenPaiementRepository.delete(moyensPaiements);
	}

	@Override
	public MoyensPaiements updateMoyensPaiements(MoyensPaiements moyensPaiements) {
		return moyenPaiementRepository.save(moyensPaiements);
	}

	@Override
	public List<MoyensPaiements> findByMoyensPaiements(String moyenPaiement) {
		return moyenPaiementRepository.findByMoyenPaiement(moyenPaiement);
	}

	@Override
	public List<MoyensPaiements> findByPaiements(Paiements paiements) {
		return moyenPaiementRepository.findByPaiements(paiements);
	}

}
