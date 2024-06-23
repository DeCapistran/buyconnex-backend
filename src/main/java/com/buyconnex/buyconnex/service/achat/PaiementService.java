package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Paiements;
import com.buyconnex.buyconnex.mapper.achat.MoyenPaiementMapper;
import com.buyconnex.buyconnex.mapper.achat.PaiementMapper;
import com.buyconnex.buyconnex.mapper.achat.StatusPaiementMapper;
import com.buyconnex.buyconnex.repository.achat.PaiementRepository;
import com.buyconnex.buyconnex.vo.achat.MoyensPaiementsVo;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;
import com.buyconnex.buyconnex.vo.achat.StatusPaiementsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaiementService implements IPaiementService{

	@Autowired
	PaiementRepository paiementRepository;
	
	@Override
	public Optional<PaiementsVo> findById(Long id) {
		return paiementRepository.findById(id).map(PaiementMapper::toVO);
	}

	@Override
	public PaiementsVo savePaiements(PaiementsVo paiementsVo) {
		Paiements paiements = PaiementMapper.toEntity(paiementsVo);
		Paiements paiementsSave = paiementRepository.save(paiements);
		return PaiementMapper.toVO(paiementsSave);
	}

	@Override
	public void deletePaiements(PaiementsVo paiementsVo) {
		Paiements paiements = PaiementMapper.toEntity(paiementsVo);
		paiementRepository.delete(paiements);
	}

	@Override
	public PaiementsVo updatePaiements(Long id, PaiementsVo paiementsVo) {
		return paiementRepository.findById(id).map(paiement -> {
			PaiementMapper.updateEntityFromVO(paiementsVo, paiement);
			Paiements paiementsUpdated = paiementRepository.save(paiement);
			return PaiementMapper.toVO(paiementsUpdated);
		}).orElse(null);
	}

	@Override
	public List<PaiementsVo> findByMoyensPaiements(MoyensPaiementsVo moyenPaiementsVo) {
		return paiementRepository.findByMoyensPaiements(MoyenPaiementMapper.toEntity(moyenPaiementsVo)).stream().map(PaiementMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<PaiementsVo> findByStatusPaiements(StatusPaiementsVo statusPaiementsVo) {
		return paiementRepository.findByStatusPaiements(StatusPaiementMapper.toEntity(statusPaiementsVo)).stream().map(PaiementMapper::toVO).collect(Collectors.toList());
	}

}
