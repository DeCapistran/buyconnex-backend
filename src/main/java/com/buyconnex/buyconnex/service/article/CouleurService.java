package com.buyconnex.buyconnex.service.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.article.Couleurs;
import com.buyconnex.buyconnex.mapper.article.CouleurMapper;
import com.buyconnex.buyconnex.repository.article.CouleurRepository;
import com.buyconnex.buyconnex.vo.article.CouleursVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CouleurService implements ICouleurService{

	CouleurRepository couleurRepository;
	
	@Override
	public Optional<CouleursVo> findById(Long id) {
		return couleurRepository.findById(id).map(CouleurMapper::toVO);
	}

	@Override
	public CouleursVo saveCouleurs(CouleursVo couleursVo) {
		Couleurs couleurs = CouleurMapper.toEntity(couleursVo);
		Couleurs couleursSave = couleurRepository.save(couleurs);
		return CouleurMapper.toVO(couleursSave);
	}

	@Override
	public void deleteCouleurs(CouleursVo couleursVo) {
		Couleurs couleurs = CouleurMapper.toEntity(couleursVo);
		couleurRepository.delete(couleurs);
	}

	@Override
	public CouleursVo updateCouleurs(Long id, CouleursVo couleursVo) {
		return couleurRepository.findById(id).map(couleur -> {
			CouleurMapper.updateEntityFromVO(couleursVo, couleur);
			Couleurs couleursUpdated = couleurRepository.save(couleur);
			return CouleurMapper.toVO(couleursUpdated);
		}).orElse(null);
	}

	@Override
	public List<CouleursVo> findByCodeCouleurs(String codeCouleur) {
		return couleurRepository.findByCodeCouleur(codeCouleur).stream().map(CouleurMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CouleursVo> findByCouleur(String couleur) {
		return couleurRepository.findByCouleur(couleur).stream().map(CouleurMapper::toVO).collect(Collectors.toList());
	}

}
