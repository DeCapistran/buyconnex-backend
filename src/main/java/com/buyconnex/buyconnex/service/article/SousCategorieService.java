package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Coupons;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.SousCategories;
import com.buyconnex.buyconnex.repository.article.SousCategorieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SousCategorieService implements ISousCategorieService{

	@Autowired
	SousCategorieRepository sousCategorieRepository;
	
	@Override
	public Optional<SousCategories> findById(Long id) {
		return sousCategorieRepository.findById(id);
	}

	@Override
	public SousCategories saveSousCategorie(SousCategories sousCategories) {
		return sousCategorieRepository.save(sousCategories);
	}

	@Override
	public void deleteSousCategorie(SousCategories sousCategories) {
		sousCategorieRepository.delete(sousCategories);
	}

	@Override
	public SousCategories updateSousCategorie(SousCategories sousCategories) {
		return sousCategorieRepository.save(sousCategories);
	}

	@Override
	public List<SousCategories> findByCategories(Categories categories) {
		return sousCategorieRepository.findByCategories(categories);
	}

	@Override
	public List<SousCategories> findByCoupons(Coupons coupons) {
		return sousCategorieRepository.findByCoupons(coupons);
	}

	@Override
	public List<SousCategories> findByLibelle(String libelle) {
		return sousCategorieRepository.findByLibelle(libelle);
	}

}
