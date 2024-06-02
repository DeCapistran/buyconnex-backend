package com.buyconnex.buyconnex.service.achat;

import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Paiements;

public interface IPaiementService {

	public Paiements findById(Long id);
	public Paiements savePaiements(Paiements paiements);
	public void deletePaiements(Paiements paiements);
	public Paiements updatePaiements(Paiements paiements);
	public List<Paiements> findByMoyensPaiements(String moyenPaiement);
	public List<Paiements> findByPaiements(Paiements paiements);
}
