package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.mapper.client.CommuneMapper;
import com.buyconnex.buyconnex.mapper.client.VilleMapper;
import com.buyconnex.buyconnex.repository.client.CommuneRepository;
import com.buyconnex.buyconnex.vo.client.CommunesVo;
import com.buyconnex.buyconnex.vo.client.VillesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommuneService implements ICommuneService {

	CommuneRepository communeRepository;
	
	@Override
	public Optional<CommunesVo> findById(Long id) {
		return communeRepository.findById(id).map(CommuneMapper::toVO);
	}

	@Override
	public CommunesVo saveCommunes(CommunesVo communesVo) {
		Communes communes = CommuneMapper.toEntity(communesVo);
		Communes communesSave = communeRepository.save(communes);
		return CommuneMapper.toVO(communesSave);
	}

	@Override
	public void deleteCommunes(CommunesVo communesVo) {
		Communes communes = CommuneMapper.toEntity(communesVo);
		communeRepository.delete(communes);
	}

	@Override
	public CommunesVo updateCommunes(Long id, CommunesVo communesVo) {
		return communeRepository.findById(id).map(commune -> {
			CommuneMapper.updateEntityFromVO(communesVo, commune);
			Communes communesUpdated = communeRepository.save(commune);
			return CommuneMapper.toVO(communesUpdated);
		}).orElse(null);
	}

	@Override
	public List<CommunesVo> findByCommune(String commune) {
		return communeRepository.findByCommune(commune).stream().map(CommuneMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<CommunesVo> findByVilles(VillesVo villesVo) {
		return communeRepository.findByVilles(VilleMapper.toEntity(villesVo)).stream().map(CommuneMapper::toVO).collect(Collectors.toList());
	}

}
