package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Boutiques;
import com.buyconnex.buyconnex.repository.article.BoutiqueRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoutiqueService implements IBoutiqueService {

	BoutiqueRepository boutiqueRepository;
	
	@Override
	public Optional<Boutiques> findById(Long id) {
		return boutiqueRepository.findById(id);
	}

	@Override
	public Boutiques saveBoutique(Boutiques boutiques) {
		return boutiqueRepository.save(boutiques);
	}

	@Override
	public void deleteBoutique(Boutiques boutiques) {
		boutiqueRepository.delete(boutiques);
	}

	@Override
	public Boutiques updateBoutique(Boutiques boutiques) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boutiques> findByArticle(Articles articles) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boutiques> findByNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Boutiques> findByimg(String img) {
		// TODO Auto-generated method stub
		return null;
	}

}
