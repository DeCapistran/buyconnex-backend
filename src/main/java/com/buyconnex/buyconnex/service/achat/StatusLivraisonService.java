package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.mapper.achat.LivraisonMapper;
import com.buyconnex.buyconnex.mapper.achat.StatusLivraisonMapper;
import com.buyconnex.buyconnex.repository.achat.StatusLivraisonRepository;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;
import com.buyconnex.buyconnex.vo.achat.StatusLivraisonsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StatusLivraisonService implements IStatusLivraisonService {

	@Autowired
	StatusLivraisonRepository statusLivraisonRepository;
	
	@Override
	public Optional<StatusLivraisonsVo> findById(Long id) {
		return statusLivraisonRepository.findById(id).map(StatusLivraisonMapper::toVO);
	}

	@Override
	public StatusLivraisonsVo saveStatusLivraisons(StatusLivraisonsVo statusLivraisonsVo) {
		StatusLivraisons statusLivraisons = StatusLivraisonMapper.toEntity(statusLivraisonsVo);
		StatusLivraisons statusLivraisonsSave = statusLivraisonRepository.save(statusLivraisons);
		return StatusLivraisonMapper.toVO(statusLivraisonsSave);
	}

	@Override
	public void deleteStatusLivraison(StatusLivraisonsVo statusLivraisonsVo) {
		StatusLivraisons statusLivraisons = StatusLivraisonMapper.toEntity(statusLivraisonsVo);
		statusLivraisonRepository.delete(statusLivraisons);
	}

	@Override
	public StatusLivraisonsVo updateStatusLivraisons(Long id, StatusLivraisonsVo statusLivraisonsVo) {
		return statusLivraisonRepository.findById(id).map(statusLivraison -> {
			StatusLivraisonMapper.updateEntityFromVO(statusLivraisonsVo, statusLivraison);
			StatusLivraisons statusLivraisonsUpdated = statusLivraisonRepository.save(statusLivraison);
			return StatusLivraisonMapper.toVO(statusLivraisonsUpdated);
		}).orElse(null);
	}

	@Override
	public List<StatusLivraisonsVo> findByLivraisons(LivraisonsVo livraisonsVo) {
		return statusLivraisonRepository.findByLivraisons(LivraisonMapper.toEntity(livraisonsVo)).stream().map(StatusLivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<StatusLivraisonsVo> findByStatus(String status) {
		return statusLivraisonRepository.findByStatus(status).stream().map(StatusLivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<StatusLivraisonsVo> findAll() {
		return statusLivraisonRepository.findAll().stream().map(StatusLivraisonMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteStatusLivraisonsById(Long id) {
		statusLivraisonRepository.deleteById(id);
	}

}
