package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.StatusCommandes;


public interface StatusCommandeRepository extends JpaRepository<StatusCommandes, Long> {

	List<StatusCommandes> findByCommandes(Commandes commandes);
	List<StatusCommandes> findByStatus(String status);
}
