package com.buyconnex.buyconnex.repository.achat;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Expeditions;


public interface ExpeditionRepository extends JpaRepository<Expeditions, Long> {

	List<Expeditions> findByCommandes(Commandes commande);
	List<Expeditions> findByDateExpedition(Date date);
}
