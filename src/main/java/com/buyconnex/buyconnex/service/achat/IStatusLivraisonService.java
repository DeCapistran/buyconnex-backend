package com.buyconnex.buyconnex.service.achat;

import java.util.List;

import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;

public interface IStatusLivraisonService {

	public StatusLivraisons findById(Long id);
	public StatusLivraisons saveStatusLivraisons(StatusLivraisons statusLivraisons);
	public void deleteStatusLivraison(StatusLivraisons statusLivraisons);
	public List<StatusLivraisons> updateStatusLivraisons(StatusLivraisons statusLivraisons);
	public List<StatusLivraisons> findByLivraisons(Livraisons livraisons);
	public List<StatusLivraisons> findByStatus(String status);
}
