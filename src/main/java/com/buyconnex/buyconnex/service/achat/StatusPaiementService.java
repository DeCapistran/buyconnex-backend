package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.entity.achat.StatusPaiements;
import com.buyconnex.buyconnex.repository.achat.StatusPaiementRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusPaiementService implements IStatusPaiementService{

	StatusPaiementRepository statusPaiementRepository;
	
	@Override
	public Optional<StatusPaiements> findById(Long id) {
		return statusPaiementRepository.findById(id);
	}

	@Override
	public StatusPaiements saveStatusPaiements(StatusPaiements statusPaiements) {
		return statusPaiementRepository.save(statusPaiements);
	}

	@Override
	public void deleteStatusPaiements(StatusPaiements statusPaiements) {
		statusPaiementRepository.delete(statusPaiements);
	}

	@Override
	public StatusPaiements updateStatusPaiements(StatusPaiements statusPaiements) {
		return statusPaiementRepository.save(statusPaiements);
	}

	@Override
	public List<StatusPaiements> findByPaiements(Paiements paiements) {
		return statusPaiementRepository.findByPaiements(paiements);
	}

	@Override
	public List<StatusPaiements> findByStatus(String status) {
		return statusPaiementRepository.findByStatus(status);
	}

}
