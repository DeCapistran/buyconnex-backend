package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;


public interface MoyenLivraisonRepository extends JpaRepository<MoyensLivraisons, Long> {

	List<MoyensLivraisons> findByCommandes(Commandes commandes);
	List<MoyensLivraisons> findByMoyenLivraison(String moyenLivraison);
}
