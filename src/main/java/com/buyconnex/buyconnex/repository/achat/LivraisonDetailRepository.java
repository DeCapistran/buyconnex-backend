package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.LivraisonsDetails;

public interface LivraisonDetailRepository extends JpaRepository<LivraisonsDetails, Long>{

	List<LivraisonsDetails> findByCommandes(Commandes commandes);
	List<LivraisonsDetails> findByLivraisons(Livraisons livraisons);
}
