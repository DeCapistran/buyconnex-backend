package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Livraisons;
import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.repository.achat.StatusLivraisonRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusLivraisonService implements IStatusLivraisonService {

	@Autowired
	StatusLivraisonRepository statusLivraisonRepository;
	
	@Override
	public Optional<StatusLivraisons> findById(Long id) {
		return statusLivraisonRepository.findById(id);
	}

	@Override
	public StatusLivraisons saveStatusLivraisons(StatusLivraisons statusLivraisons) {
		return statusLivraisonRepository.save(statusLivraisons);
	}

	@Override
	public void deleteStatusLivraison(StatusLivraisons statusLivraisons) {
		statusLivraisonRepository.delete(statusLivraisons);
	}

	@Override
	public StatusLivraisons updateStatusLivraisons(StatusLivraisons statusLivraisons) {
		return statusLivraisonRepository.save(statusLivraisons);
	}

	@Override
	public List<StatusLivraisons> findByLivraisons(Livraisons livraisons) {
		return statusLivraisonRepository.findByLivraisons(livraisons);
	}

	@Override
	public List<StatusLivraisons> findByStatus(String status) {
		return statusLivraisonRepository.findByStatus(status);
	}

}
