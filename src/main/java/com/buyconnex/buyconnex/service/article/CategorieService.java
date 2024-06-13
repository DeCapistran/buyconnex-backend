package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.article.Categories;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.entity.article.SousCategories;
import com.buyconnex.buyconnex.repository.article.CategorieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategorieService implements ICategorieService{

	CategorieRepository categorieRepository;
	
	@Override
	public Optional<Categories> findById(Long id) {
		return categorieRepository.findById(id);
	}

	@Override
	public Categories saveCategorie(Categories categories) {
		return categorieRepository.save(categories);
	}

	@Override
	public void deleteCategorie(Categories categories) {
		categorieRepository.delete(categories);
	}

	@Override
	public Categories updateCategorie(Categories categories) {
		return categorieRepository.save(categories);
	}

	@Override
	public List<Categories> findByArticles(Articles articles) {
		return categorieRepository.findByArticles(articles);
	}

	@Override
	public List<Categories> findByImages(Images images) {
		return categorieRepository.findByImages(images);
	}

	@Override
	public List<Categories> findByLibelle(String libelle) {
		return categorieRepository.findByLibelle(libelle);
	}

	@Override
	public List<Categories> findBySousCategories(SousCategories sousCategories) {
		return categorieRepository.findBySousCategorie(sousCategories);
	}

}
