package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.repository.achat.StatusCommandeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusCommandeService implements IStatusCommandeService {

	@Autowired
	StatusCommandeRepository statusCommandeRepository;
	
	@Override
	public Optional<StatusCommandes> findById(Long id) {
		return statusCommandeRepository.findById(id);
	}

	@Override
	public StatusCommandes saveStatusCommandes(StatusCommandes statusCommandes) {
		return statusCommandeRepository.save(statusCommandes);
	}

	@Override
	public void deleteStatusCommandes(StatusCommandes statusCommandes) {
		statusCommandeRepository.delete(statusCommandes);
	}

	@Override
	public StatusCommandes updateStatusCommandes(StatusCommandes statusCommandes) {
		return statusCommandeRepository.save(statusCommandes);
	}

	@Override
	public List<StatusCommandes> findByCommandes(Commandes commandes) {
		return statusCommandeRepository.findByCommandes(commandes);
	}

	@Override
	public List<StatusCommandes> findByStatus(String status) {
		return statusCommandeRepository.findByStatus(status);
	}

}
