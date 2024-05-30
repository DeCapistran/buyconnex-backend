package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.entity.achat.Paiements;



public interface PaiementRepository extends JpaRepository<MoyensPaiements, Long> {

	List<MoyensPaiements> findByMoyenPaiement(String moyenPaiement);
	List<MoyensPaiements> findByPaiements(Paiements paiements);
}
