package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Expeditions;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.achat.ExpeditionMapper;
import com.buyconnex.buyconnex.repository.achat.ExpeditionRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.ExpeditionsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ExpeditionService implements IExpeditionService{

	@Autowired
	ExpeditionRepository expeditionRepository;
	
	@Override
	public Optional<ExpeditionsVo> findById(Long id) {
		return expeditionRepository.findById(id).map(ExpeditionMapper::toVO);
	}

	@Override
	public ExpeditionsVo saveExpeditions(ExpeditionsVo expeditionsVo) {
		Expeditions expeditions = ExpeditionMapper.toEntity(expeditionsVo);
		Expeditions expeditionsSave = expeditionRepository.save(expeditions);
		return ExpeditionMapper.toVO(expeditionsSave);
	}

	@Override
	public void deleteExpeditions(ExpeditionsVo expeditionsVo) {
		Expeditions expeditions = ExpeditionMapper.toEntity(expeditionsVo);
		expeditionRepository.delete(expeditions);
	}

	@Override
	public ExpeditionsVo updateExpeditions(Long id, ExpeditionsVo expeditionsVo) {
		return expeditionRepository.findById(id).map(expedition -> {
			ExpeditionMapper.updateEntityFromVO(expeditionsVo, expedition);
			Expeditions expeditionUpdated = expeditionRepository.save(expedition);
			return ExpeditionMapper.toVO(expeditionUpdated);
		}).orElse(null);
	}

	@Override
	public List<ExpeditionsVo> findByCommandes(CommandesVo commandesVo) {
		return expeditionRepository.findByCommandes(CommandeMapper.toEntity(commandesVo)).stream().map(ExpeditionMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ExpeditionsVo> findByDateExpeditions(Date date) {
		return expeditionRepository.findByDateExpedition(date).stream().map(ExpeditionMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<ExpeditionsVo> findAll() {
		return expeditionRepository.findAll().stream().map(ExpeditionMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteExpeditionsById(Long id) {
		expeditionRepository.deleteById(id);
	}

}
