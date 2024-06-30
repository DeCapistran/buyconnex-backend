package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.mapper.client.CommuneMapper;
import com.buyconnex.buyconnex.mapper.client.PaysMapper;
import com.buyconnex.buyconnex.mapper.client.VilleMapper;
import com.buyconnex.buyconnex.repository.client.VilleRepository;
import com.buyconnex.buyconnex.vo.client.CommunesVo;
import com.buyconnex.buyconnex.vo.client.PaysVo;
import com.buyconnex.buyconnex.vo.client.VillesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VilleService implements IVilleService {

	VilleRepository villeRepository;
	
	@Override
	public Optional<VillesVo> findById(Long id) {
		return villeRepository.findById(id).map(VilleMapper::toVO);
	}

	@Override
	public VillesVo saveVilles(VillesVo villesVo) {
		Villes villes = VilleMapper.toEntity(villesVo);
		Villes villesSave = villeRepository.save(villes);
		return VilleMapper.toVO(villesSave);
	}

	@Override
	public void deleteVilles(VillesVo villesVo) {
		Villes villes = VilleMapper.toEntity(villesVo);
		villeRepository.delete(villes);
	}

	@Override
	public VillesVo updateVilles(Long id, VillesVo villesVo) {
		return villeRepository.findById(id).map(ville -> {
			VilleMapper.updateEntityFromVO(villesVo, ville);
			Villes villesUpdated = villeRepository.save(ville);
			return VilleMapper.toVO(villesUpdated);
		}).orElse(null);
	}

	@Override
	public List<VillesVo> findByCommunes(CommunesVo communesVo) {
		return villeRepository.findByCommunes(CommuneMapper.toEntity(communesVo)).stream().map(VilleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<VillesVo> findByPays(PaysVo paysVo) {
		return villeRepository.findByPays(PaysMapper.toEntity(paysVo)).stream().map(VilleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<VillesVo> findByVilles(String ville) {
		return villeRepository.findByVille(ville).stream().map(VilleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<VillesVo> findAll() {
		return villeRepository.findAll().stream().map(VilleMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deleteVillesByid(Long id) {
		villeRepository.deleteById(id);
	}

}
