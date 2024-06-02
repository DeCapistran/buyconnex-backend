package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.entity.client.Adresses;

public interface ILivraisonService {

	public Livraisons findById(Long id);
	public Livraisons saveLivraisons(Livraisons livraisons);
	public void deleteLivraisons(Livraisons livraisons);
	public Livraisons updateLivraisons(Livraisons livraisons);
	public List<Livraisons> findByCommandes(Commandes commandes);
	public List<Livraisons> findByAdresses(Adresses adresses);
	public List<Livraisons> findByDateLivraisons(Date date);
	public Livraisons findByNumeroLivraisons(String numeroLivraison);
	public List<Livraisons> findByStatusLivraisons(StatusLivraisons statusLivraisons);
}
