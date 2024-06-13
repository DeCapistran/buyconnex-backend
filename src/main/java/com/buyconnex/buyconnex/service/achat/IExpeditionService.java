package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Expeditions;

public interface IExpeditionService {

	public Optional<Expeditions> findById(Long id);
	public Expeditions saveExpeditions(Expeditions expeditions);
	public void deleteExpeditions(Expeditions expeditions);
	public Expeditions updateExpeditions(Expeditions expeditions);
	public List<Expeditions> findByCommandes(Commandes commandes);
	public List<Expeditions> findByDateExpeditions(Date date);
}
