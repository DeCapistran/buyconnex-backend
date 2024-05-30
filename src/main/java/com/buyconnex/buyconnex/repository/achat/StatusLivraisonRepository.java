package com.buyconnex.buyconnex.repository.achat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;


public interface StatusLivraisonRepository extends JpaRepository<StatusLivraisons, Long> {

	List<StatusLivraisons> findByLivraisons(Livraisons livraisons);
	List<StatusLivraisons> findByStatus(String status);
}
