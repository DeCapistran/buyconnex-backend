package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.mapper.achat.CommandeMapper;
import com.buyconnex.buyconnex.mapper.achat.FacturationMapper;
import com.buyconnex.buyconnex.repository.achat.FacturationRepository;
import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.FacturationsVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FacturationService implements IFacturationService {
	
	@Autowired
	FacturationRepository facturationRepository;

	@Override
	public Optional<FacturationsVo> findById(Long id) {
		return facturationRepository.findById(id).map(FacturationMapper::toVO);
	}

	@Override
	public FacturationsVo saveFacturations(FacturationsVo facturationsVo) {
		Facturations facturations = FacturationMapper.toEntity(facturationsVo);
		Facturations facturationsSave = facturationRepository.save(facturations);
		return FacturationMapper.toVO(facturationsSave);
	}

	@Override
	public void deleteFacturations(FacturationsVo facturationsVo) {
		Facturations facturations = FacturationMapper.toEntity(facturationsVo);
		facturationRepository.delete(facturations);
	}

	@Override
	public FacturationsVo updateFacturations(Long id, FacturationsVo facturationsVo) {
		return facturationRepository.findById(id).map(facturation -> {
			FacturationMapper.updateEntityFromVO(facturationsVo, facturation);
			Facturations facturationsUpdated = facturationRepository.save(facturation);
			return FacturationMapper.toVO(facturationsUpdated);
		}).orElse(null);
	}

	@Override
	public List<FacturationsVo> findByDateFacturation(Date date) {
		return facturationRepository.findByDateFacturation(date).stream().map(FacturationMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<FacturationsVo> findByCommandes(CommandesVo commandesVo) {
		return facturationRepository.findByCommandes(CommandeMapper.toEntity(commandesVo)).stream().map(FacturationMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<FacturationsVo> findAll() {
		return facturationRepository.findAll().stream().map(FacturationMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deletefacturationsById(Long id) {
		facturationRepository.deleteById(id);
	}

}
