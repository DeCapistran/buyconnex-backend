package com.buyconnex.buyconnex.service.client;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.mapper.client.PanierMapper;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.repository.client.PanierRepository;
import com.buyconnex.buyconnex.vo.client.PaniersVo;
import com.buyconnex.buyconnex.vo.user.UsersVo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PanierService implements IPanierService {
	
	PanierRepository panierRepository;

	@Override
	public Optional<PaniersVo> findById(Long id) {
		return panierRepository.findById(id).map(PanierMapper::toVO);
	}

	@Override
	public PaniersVo savePaniers(PaniersVo paniersVo) {
		Paniers paniers = PanierMapper.toEntity(paniersVo);
		Paniers paniersSave = panierRepository.save(paniers);
		return PanierMapper.toVO(paniersSave);
	}

	@Override
	public void deletePaniers(PaniersVo paniersVo) {
		Paniers paniers = PanierMapper.toEntity(paniersVo);
		panierRepository.delete(paniers);
	}

	@Override
	public PaniersVo updatePaniers(Long id, PaniersVo paniersVo) {
		return panierRepository.findById(id).map(panier -> {
			PanierMapper.updateEntityFromVO(paniersVo, panier);
			Paniers paniersUpdated = panierRepository.save(panier);
			return PanierMapper.toVO(paniersUpdated);
		}).orElse(null);
	}

	@Override
	public List<PaniersVo> findBydatePaniers(Date date) {
		return panierRepository.findByDatePanier(date).stream().map(PanierMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<PaniersVo> findByUsers(UsersVo usersVo) {
		return panierRepository.findByUsers(UserMapper.toEntity(usersVo)).stream().map(PanierMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public List<PaniersVo> findAll() {
		return panierRepository.findAll().stream().map(PanierMapper::toVO).collect(Collectors.toList());
	}

	@Override
	public void deletePaniersById(Long id) {
		panierRepository.deleteById(id);
	}

}
