package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.entity.article.Images;
import com.buyconnex.buyconnex.repository.article.CouleurRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CouleurService implements ICouleurService{

	CouleurRepository couleurRepository;
	
	@Override
	public Optional<Couleurs> findById(Long id) {
		return couleurRepository.findById(id);
	}

	@Override
	public Couleurs saveCouleurs(Couleurs couleurs) {
		return couleurRepository.save(couleurs);
	}

	@Override
	public void deleteCouleurs(Couleurs couleurs) {
		couleurRepository.delete(couleurs);
	}

	@Override
	public Couleurs updateCouleurs(Couleurs couleurs) {
		return couleurRepository.save(couleurs);
	}

	@Override
	public List<Couleurs> findByCodeCouleurs(String codeCouleur) {
		return couleurRepository.findByCodeCouleur(codeCouleur);
	}

	@Override
	public List<Couleurs> findByCouleur(String couleur) {
		return couleurRepository.findByCouleur(couleur);
	}

	@Override
	public List<Couleurs> findByImages(Images images) {
		return couleurRepository.findByImages(images);
	}

}
