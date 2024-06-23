package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.MoyensPaiementsVo;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;
import com.buyconnex.buyconnex.vo.achat.StatusPaiementsVo;

public interface IPaiementService {

	public Optional<PaiementsVo> findById(Long id);
	public PaiementsVo savePaiements(PaiementsVo paiementsVo);
	public void deletePaiements(PaiementsVo paiementsVo);
	public PaiementsVo updatePaiements(Long id, PaiementsVo paiementsVo);
	public List<PaiementsVo> findByMoyensPaiements(MoyensPaiementsVo moyenPaiementsVo);
	public List<PaiementsVo> findByStatusPaiements(StatusPaiementsVo statusPaiementsVo);
}
