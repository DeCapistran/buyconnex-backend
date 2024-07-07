package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.achat.MoyenLivraisonMapper;
import com.buyconnex.buyconnex.repository.achat.MoyenLivraisonRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.MoyensLivraisonsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MoyenLivraisonService implements IMoyenLivraisonService {

	@Autowired
	MoyenLivraisonRepository moyenLivraisonRepository;
	
	@Override
	public Optional<MoyensLivraisonsVo> findById(Long id) {
		return moyenLivraisonRepository.findById(id).map(MoyenLivraisonMapper::toVO);
	}

	@Override
	public MoyensLivraisonsVo saveMoyensLivraisons(MoyensLivraisonsVo moyensLivraisonsVo) {
		MoyensLivraisons moyensLivraisons = MoyenLivraisonMapper.toEntity(moyensLivraisonsVo);
		MoyensLivraisons moyensLivraisonsSave = moyenLivraisonRepository.save(moyensLivraisons);
		return MoyenLivraisonMapper.toVO(moyensLivraisonsSave);
	}

	@Override
	public void deleteMoyensLivraisons(MoyensLivraisonsVo moyensLivraisonsVo) {
		MoyensLivraisons moyensLivraisons = MoyenLivraisonMapper.toEntity(moyensLivraisonsVo);
		moyenLivraisonRepository.delete(moyensLivraisons);
	}

	@Override
	public MoyensLivraisonsVo updateMoyensLivraisons(Long id, MoyensLivraisonsVo moyensLivraisonsVo) {
		return moyenLivraisonRepository.findById(id).map(moyenLivraison -> {
			MoyenLivraisonMapper.updateEntityFromVO(moyensLivraisonsVo, moyenLivraison);
			MoyensLivraisons moyensLivraisonsUpdated = moyenLivraisonRepository.save(moyenLivraison);
			return MoyenLivraisonMapper.toVO(moyensLivraisonsUpdated);
		}).orElse(null);
	}

	@Override
	public List<MoyensLivraisonsVo> findByCommandes(CommandesVo commandesVo) {
		return moyenLivraisonRepository.findByCommandes(CommandeMapper.toEntity(commandesVo)).stream().map(MoyenLivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<MoyensLivraisonsVo> findByMoyensLivraisons(String moyenLivraison) {
		return moyenLivraisonRepository.findByMoyenLivraison(moyenLivraison).stream().map(MoyenLivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<MoyensLivraisonsVo> findAll() {
		return moyenLivraisonRepository.findAll().stream().map(MoyenLivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteMoyensLivraisonsById(Long id) {
		moyenLivraisonRepository.deleteById(id);
	}

}
