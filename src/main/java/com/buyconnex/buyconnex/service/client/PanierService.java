package com.buyconnex.buyconnex.service.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.repository.client.PanierRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PanierService implements IPanierService {
	
	PanierRepository panierRepository;

	@Override
	public Optional<Paniers> findById(Long id) {
		return panierRepository.findById(id);
	}

	@Override
	public Paniers savePaniers(Paniers paniers) {
		return panierRepository.save(paniers);
	}

	@Override
	public void deletePaniers(Paniers paniers) {
		panierRepository.delete(paniers);
	}

	@Override
	public Paniers updatePaniers(Paniers paniers) {
		return panierRepository.save(paniers);
	}

	@Override
	public List<Paniers> findByArticles(Articles articles) {
		return panierRepository.findByArticles(articles);
	}

	@Override
	public List<Paniers> findBydatePaniers(Date date) {
		return panierRepository.findByDatePanier(date);
	}

	@Override
	public List<Paniers> findByUsers(Users users) {
		return panierRepository.findByUsers(users);
	}

}
