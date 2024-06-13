package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.entity.article.Images;

public interface ICouleurService {

	public Optional<Couleurs> findById(Long id);
	public Couleurs saveCouleurs(Couleurs couleurs);
	public void deleteCouleurs(Couleurs couleurs);
	public Couleurs updateCouleurs(Couleurs couleurs);
	public List<Couleurs> findByCodeCouleurs(String codeCouleur);
	public List<Couleurs> findByCouleur(String couleur);
	public List<Couleurs> findByImages(Images images);
}
