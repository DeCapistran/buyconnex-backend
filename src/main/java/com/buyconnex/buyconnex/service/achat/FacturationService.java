package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.repository.achat.FacturationRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacturationService implements IFacturationService {
	
	@Autowired
	FacturationRepository facturationRepository;

	@Override
	public Optional<Facturations> findById(Long id) {
		return facturationRepository.findById(id);
	}

	@Override
	public Facturations saveFacturations(Facturations facturations) {
		return facturationRepository.save(facturations);
	}

	@Override
	public void deleteFacturations(Facturations facturations) {
		facturationRepository.delete(facturations);
	}

	@Override
	public Facturations updateFacturations(Facturations facturations) {
		return facturationRepository.save(facturations);
	}

	@Override
	public List<Facturations> findByDateFacturation(Date date) {
		return facturationRepository.findByDateFacturation(date);
	}

	@Override
	public List<Facturations> findByCommandes(Commandes commandes) {
		return facturationRepository.findByCommandes(commandes);
	}

}
