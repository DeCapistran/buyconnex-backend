package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Marques;
import com.buyconnex.buyconnex.repository.article.MarqueRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MarqueService implements IMarqueService {

	@Autowired
	MarqueRepository marqueRepository;
	
	@Override
	public Optional<Marques> findById(Long id) {
		return marqueRepository.findById(id);
	}

	@Override
	public Marques saveMarques(Marques marques) {
		return marqueRepository.save(marques);
	}

	@Override
	public void deleteMarques(Marques marques) {
		marqueRepository.delete(marques);
	}

	@Override
	public Marques updateMarques(Marques marques) {
		return marqueRepository.save(marques);
	}

	@Override
	public List<Marques> findByArticles(Articles articles) {
		return marqueRepository.findByArticles(articles);
	}

	@Override
	public List<Marques> findByImg(String img) {
		return marqueRepository.findByImg(img);
	}

	@Override
	public List<Marques> findByLibelle(String libelle) {
		return marqueRepository.findByLibelle(libelle);
	}

}
