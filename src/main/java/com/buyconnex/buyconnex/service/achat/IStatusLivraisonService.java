package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;

public interface IStatusLivraisonService {

	public Optional<StatusLivraisons> findById(Long id);
	public StatusLivraisons saveStatusLivraisons(StatusLivraisons statusLivraisons);
	public void deleteStatusLivraison(StatusLivraisons statusLivraisons);
	public StatusLivraisons updateStatusLivraisons(StatusLivraisons statusLivraisons);
	public List<StatusLivraisons> findByLivraisons(Livraisons livraisons);
	public List<StatusLivraisons> findByStatus(String status);
}
