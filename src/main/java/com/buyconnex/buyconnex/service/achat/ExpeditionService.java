package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Expeditions;
import com.buyconnex.buyconnex.repository.achat.ExpeditionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExpeditionService implements IExpeditionService{

	@Autowired
	ExpeditionRepository expeditionRepository;
	
	@Override
	public Optional<Expeditions> findById(Long id) {
		return expeditionRepository.findById(id);
	}

	@Override
	public Expeditions saveExpeditions(Expeditions expeditions) {
		return expeditionRepository.save(expeditions);
	}

	@Override
	public void deleteExpeditions(Expeditions expeditions) {
		expeditionRepository.delete(expeditions);
	}

	@Override
	public Expeditions updateExpeditions(Expeditions expeditions) {
		return expeditionRepository.save(expeditions);
	}

	@Override
	public List<Expeditions> findByCommandes(Commandes commandes) {
		return expeditionRepository.findByCommandes(commandes);
	}

	@Override
	public List<Expeditions> findByDateExpeditions(Date date) {
		return expeditionRepository.findByDateExpedition(date);
	}

}
