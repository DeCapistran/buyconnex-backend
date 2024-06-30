package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.PaiementsVo;
import com.buyconnex.buyconnex.vo.achat.StatusPaiementsVo;

public interface IStatusPaiementService {

	public Optional<StatusPaiementsVo> findById(Long id);
	public List<StatusPaiementsVo> findAll();
	public StatusPaiementsVo saveStatusPaiements(StatusPaiementsVo statusPaiementsVo);
	public void deleteStatusPaiements(StatusPaiementsVo statusPaiementsVo);
	public void deleteStatusPaiementsById(Long id);
	public StatusPaiementsVo updateStatusPaiements(Long id, StatusPaiementsVo statusPaiementsVo);
	public List<StatusPaiementsVo> findByPaiements(PaiementsVo paiementsVo);
	public List<StatusPaiementsVo> findByStatus(String status);
}
