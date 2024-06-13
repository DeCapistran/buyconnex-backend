package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.entity.achat.StatusPaiements;

public interface IPaiementService {

	public Optional<Paiements> findById(Long id);
	public Paiements savePaiements(Paiements paiements);
	public void deletePaiements(Paiements paiements);
	public Paiements updatePaiements(Paiements paiements);
	public List<Paiements> findByMoyensPaiements(MoyensPaiements moyenPaiement);
	public List<Paiements> findByStatusPaiements(StatusPaiements statusPaiements);
}
