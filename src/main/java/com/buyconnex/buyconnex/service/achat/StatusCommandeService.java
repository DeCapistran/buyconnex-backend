package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.achat.StatusCommandeMapper;
import com.buyconnex.buyconnex.repository.achat.StatusCommandeRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusCommandeService implements IStatusCommandeService {

	@Autowired
	StatusCommandeRepository statusCommandeRepository;
	
	@Override
	public Optional<StatusCommandesVo> findById(Long id) {
		return statusCommandeRepository.findById(id).map(StatusCommandeMapper::toVO);
	}

	@Override
	public StatusCommandesVo saveStatusCommandes(StatusCommandesVo statusCommandesVo) {
		StatusCommandes statusCommandes = StatusCommandeMapper.toEntity(statusCommandesVo);
		StatusCommandes statusCommandesSave = statusCommandeRepository.save(statusCommandes);
		return StatusCommandeMapper.toVO(statusCommandesSave);
	}

	@Override
	public void deleteStatusCommandes(StatusCommandesVo statusCommandesVo) {
		StatusCommandes statusCommandes = StatusCommandeMapper.toEntity(statusCommandesVo);
		statusCommandeRepository.delete(statusCommandes);
	}

	@Override
	public StatusCommandesVo updateStatusCommandes(Long id, StatusCommandesVo statusCommandesVo) {
		return statusCommandeRepository.findById(id).map(statusCommande -> {
			StatusCommandeMapper.updateEntityFromVO(statusCommandesVo, statusCommande);
			StatusCommandes statusCommandesUpdated = statusCommandeRepository.save(statusCommande);
			return StatusCommandeMapper.toVO(statusCommandesUpdated);
		}).orElse(null);
	}

	@Override
	public List<StatusCommandesVo> findByCommandes(CommandesVo commandesVo) {
		return statusCommandeRepository.findByCommandes(CommandeMapper.toEntity(commandesVo)).stream().map(StatusCommandeMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<StatusCommandesVo> findByStatus(String status) {
		return statusCommandeRepository.findByStatus(status).stream().map(StatusCommandeMapper::toVO).collect(Collectors.toList());
	}

}
