package com.buyconnex.buyconnex.repository.achat;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.entity.client.Adresses;




public interface LivraisonRepository extends JpaRepository<Livraisons, Long>{

	List<Livraisons> findByCommandes(Commandes commandes);
	List<Livraisons> findByAdresses(Adresses adresses);
	List<Livraisons> findByDateLivraison(Date dateLivraison);
	List<Livraisons> findByNumeroLivraison(String numeroLivraison);
	List<Livraisons> findByStatusLivraisons(StatusLivraisons statusLivraisons);
}
