package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.repository.article.AvisRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AvisService implements IAvisService{

	@Autowired
	AvisRepository avisRepository;
	
	@Override
	public Optional<Avis> findById(Long id) {
		return avisRepository.findById(id);
	}

	@Override
	public Avis saveAvis(Avis avis) {
		return avisRepository.save(avis);
	}

	@Override
	public void deleteAvis(Avis avis) {
		avisRepository.delete(avis);
	}

	@Override
	public Avis updateAvis(Avis avis) {
		return avisRepository.save(avis);
	}

	@Override
	public List<Avis> findByArticles(Articles articles) {
		return avisRepository.findByArticles(articles);
	}

	@Override
	public List<Avis> findByEtoile(int etoile) {
		return avisRepository.findByEtoile(etoile);
	}

	@Override
	public List<Avis> findByUsers(Users users) {
		return avisRepository.findByUsers(users);
	}

}
