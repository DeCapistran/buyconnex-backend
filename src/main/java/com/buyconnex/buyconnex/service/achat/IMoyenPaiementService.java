package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.entity.achat.Paiements;

public interface IMoyenPaiementService {

	public Optional<MoyensPaiements> findById(Long id);
	public MoyensPaiements saveMoyensPaiements(MoyensPaiements moyensPaiements);
	public void deleteMoyensPaiements(MoyensPaiements moyensPaiements);
	public MoyensPaiements updateMoyensPaiements(MoyensPaiements moyensPaiements);
	public List<MoyensPaiements> findByMoyensPaiements(String moyenPaiement);
	public List<MoyensPaiements> findByPaiements(Paiements paiements);
}
