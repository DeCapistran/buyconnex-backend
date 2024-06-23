package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.MoyensPaiements;
import com.buyconnex.buyconnex.mapper.achat.MoyenPaiementMapper;
import com.buyconnex.buyconnex.mapper.achat.PaiementMapper;
import com.buyconnex.buyconnex.repository.achat.MoyenPaiementRepository;
import com.buyconnex.buyconnex.vo.achat.MoyensPaiementsVo;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MoyenPaiementService implements IMoyenPaiementService {

	MoyenPaiementRepository moyenPaiementRepository;
	
	@Override
	public Optional<MoyensPaiementsVo> findById(Long id) {
		return moyenPaiementRepository.findById(id).map(MoyenPaiementMapper::toVO);
	}

	@Override
	public MoyensPaiementsVo saveMoyensPaiements(MoyensPaiementsVo moyensPaiementsVo) {
		MoyensPaiements moyensPaiements = MoyenPaiementMapper.toEntity(moyensPaiementsVo);
		MoyensPaiements moyensPaiementsSave = moyenPaiementRepository.save(moyensPaiements);
		return MoyenPaiementMapper.toVO(moyensPaiementsSave);
	}

	@Override
	public void deleteMoyensPaiements(MoyensPaiementsVo moyensPaiementsVo) {
		MoyensPaiements moyensPaiements = MoyenPaiementMapper.toEntity(moyensPaiementsVo);
		moyenPaiementRepository.delete(moyensPaiements);
	}

	@Override
	public MoyensPaiementsVo updateMoyensPaiements(Long id, MoyensPaiementsVo moyensPaiementsVo) {
		return moyenPaiementRepository.findById(id).map(moyenPaiement -> {
			MoyenPaiementMapper.updateEntityFromVO(moyensPaiementsVo, moyenPaiement);
			MoyensPaiements moyensPaiementsUpdated = moyenPaiementRepository.save(moyenPaiement);
			return MoyenPaiementMapper.toVO(moyensPaiementsUpdated);
		}).orElse(null);
	}

	@Override
	public List<MoyensPaiementsVo> findByMoyensPaiements(String moyenPaiement) {
		return moyenPaiementRepository.findByMoyenPaiement(moyenPaiement).stream().map(MoyenPaiementMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<MoyensPaiementsVo> findByPaiements(PaiementsVo paiementsVo) {
		return moyenPaiementRepository.findByPaiements(PaiementMapper.toEntity(paiementsVo)).stream().map(MoyenPaiementMapper::toVO).collect(Collectors.toList());
	}

}
