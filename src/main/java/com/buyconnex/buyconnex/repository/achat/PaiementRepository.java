package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.entity.achat.StatusPaiements;



public interface PaiementRepository extends JpaRepository<Paiements, Long> {

	List<Paiements> findByMoyensPaiements(MoyensPaiements moyensPaiements);
	List<Paiements> findByStatusPaiements(StatusPaiements statusPaiements);
}
