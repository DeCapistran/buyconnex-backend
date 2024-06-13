package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.entity.achat.StatusPaiements;

public interface IStatusPaiementService {

	public Optional<StatusPaiements> findById(Long id);
	public StatusPaiements saveStatusPaiements(StatusPaiements statusPaiements);
	public void deleteStatusPaiements(StatusPaiements statusPaiements);
	public StatusPaiements updateStatusPaiements(StatusPaiements statusPaiements);
	public List<StatusPaiements> findByPaiements(Paiements paiements);
	public List<StatusPaiements> findByStatus(String status);
}
