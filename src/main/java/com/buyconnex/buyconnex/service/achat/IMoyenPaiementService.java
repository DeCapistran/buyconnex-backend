package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.MoyensPaiementsVo;
import com.buyconnex.buyconnex.vo.achat.PaiementsVo;

public interface IMoyenPaiementService {

	public Optional<MoyensPaiementsVo> findById(Long id);
	public MoyensPaiementsVo saveMoyensPaiements(MoyensPaiementsVo moyensPaiementsVo);
	public void deleteMoyensPaiements(MoyensPaiementsVo moyensPaiementsVo);
	public MoyensPaiementsVo updateMoyensPaiements(Long id, MoyensPaiementsVo moyensPaiementsVo);
	public List<MoyensPaiementsVo> findByMoyensPaiements(String moyenPaiement);
	public List<MoyensPaiementsVo> findByPaiements(PaiementsVo paiementsVo);
}
