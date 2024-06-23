package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.StatusPaiements;
import com.buyconnex.buyconnex.mapper.achat.PaiementMapper;
import com.buyconnex.buyconnex.mapper.achat.StatusPaiementMapper;
import com.buyconnex.buyconnex.repository.achat.StatusPaiementRepository;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;
import com.buyconnex.buyconnex.vo.achat.StatusPaiementsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusPaiementService implements IStatusPaiementService{

	StatusPaiementRepository statusPaiementRepository;
	
	@Override
	public Optional<StatusPaiementsVo> findById(Long id) {
		return statusPaiementRepository.findById(id).map(StatusPaiementMapper::toVO);
	}

	@Override
	public StatusPaiementsVo saveStatusPaiements(StatusPaiementsVo statusPaiementsVo) {
		StatusPaiements statusPaiements = StatusPaiementMapper.toEntity(statusPaiementsVo);
		StatusPaiements statusPaiementsSave = statusPaiementRepository.save(statusPaiements);
		return StatusPaiementMapper.toVO(statusPaiementsSave);
	}

	@Override
	public void deleteStatusPaiements(StatusPaiementsVo statusPaiementsVo) {
		StatusPaiements statusPaiements = StatusPaiementMapper.toEntity(statusPaiementsVo);
		statusPaiementRepository.delete(statusPaiements);
	}

	@Override
	public StatusPaiementsVo updateStatusPaiements(Long id, StatusPaiementsVo statusPaiementsVo) {
		return statusPaiementRepository.findById(id).map(statusPaiement -> {
			StatusPaiementMapper.updateEntityFromVO(statusPaiementsVo, statusPaiement);
			StatusPaiements statusPaiementsUpdated = statusPaiementRepository.save(statusPaiement);
			return StatusPaiementMapper.toVO(statusPaiementsUpdated);
		}).orElse(null);
	}

	@Override
	public List<StatusPaiementsVo> findByPaiements(PaiementsVo paiementsVo) {
		return statusPaiementRepository.findByPaiements(PaiementMapper.toEntity(paiementsVo)).stream().map(StatusPaiementMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<StatusPaiementsVo> findByStatus(String status) {
		return statusPaiementRepository.findByStatus(status).stream().map(StatusPaiementMapper::toVO).collect(Collectors.toList())


;
	}

}
