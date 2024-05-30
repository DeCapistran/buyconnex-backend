package com.buyconnex.buyconnex.repository.achat;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Facturations;


public interface FacturationRepository extends JpaRepository<Facturations, Long> {

	List<Facturations> findByDateFacturation(Date date);
	List<Facturations> findByCommandes(Commandes commande);
}
