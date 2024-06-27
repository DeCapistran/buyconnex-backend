package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.article.CouleursVo;

public interface ICouleurService {

	public Optional<CouleursVo> findById(Long id);
	public CouleursVo saveCouleurs(CouleursVo couleursVo);
	public void deleteCouleurs(CouleursVo couleursVo);
	public CouleursVo updateCouleurs(Long id, CouleursVo couleursVo);
	public List<CouleursVo> findByCodeCouleurs(String codeCouleur);
	public List<CouleursVo> findByCouleur(String couleur);
}
