package com.buyconnex.buyconnex.service.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.mapper.client.PaysMapper;
import com.buyconnex.buyconnex.mapper.client.VilleMapper;
import com.buyconnex.buyconnex.repository.client.PaysRepository;
import com.buyconnex.buyconnex.vo.client.PaysVo;
import com.buyconnex.buyconnex.vo.client.VillesVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaysService implements IPaysService {

	@Autowired
	PaysRepository paysRepository;
	
	@Override
	public Optional<PaysVo> findById(Long id) {
		return paysRepository.findById(id).map(PaysMapper::toVO);
	}

	@Override
	public PaysVo savePays(PaysVo paysVo) {
		Pays pays = PaysMapper.toEntity(paysVo);
		Pays paysSave = paysRepository.save(pays);
		return PaysMapper.toVO(paysSave);
	}

	@Override
	public void deletePays(PaysVo paysVo) {
		Pays pays = PaysMapper.toEntity(paysVo);
		paysRepository.delete(pays);
	}

	@Override
	public PaysVo updatePays(Long id, PaysVo paysVo) {
		return paysRepository.findById(id).map(pays -> {
			PaysMapper.updateEntityFromVO(paysVo, pays);
			Pays paysUpdated = paysRepository.save(pays);
			return PaysMapper.toVO(paysUpdated);
		}).orElse(null);
	}

	@Override
	public List<PaysVo> findByPays(String pays) {
		return paysRepository.findByPays(pays).stream().map(PaysMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<PaysVo> findByVilles(VillesVo villesVo) {
		return paysRepository.findByVilles(VilleMapper.toEntity(villesVo)).stream().map(PaysMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<PaysVo> findAll() {
		return paysRepository.findAll().stream().map(PaysMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deletePaysById(Long id) {
		paysRepository.deleteById(id);
	}

}
