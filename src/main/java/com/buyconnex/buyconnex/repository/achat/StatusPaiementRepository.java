package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.entity.achat.StatusPaiements;


public interface StatusPaiementRepository extends JpaRepository<StatusPaiements, Long> {

	List<StatusPaiements> findByPaiements(Paiements paiements);
	List<StatusPaiements> findByStatus(String status);
}
