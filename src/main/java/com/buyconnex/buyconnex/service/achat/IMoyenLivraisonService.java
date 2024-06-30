package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.MoyensLivraisonsVo;

public interface IMoyenLivraisonService {

	public Optional<MoyensLivraisonsVo> findByid(Long id);
	public List<MoyensLivraisonsVo> findAll();
	public MoyensLivraisonsVo saveMoyensLivraisons(MoyensLivraisonsVo moyensLivraisonsVo);
	public void deleteMoyensLivraisons(MoyensLivraisonsVo moyensLivraisonsVo);
	public void deleteMoyensLivraisonsById(Long id);
	public MoyensLivraisonsVo updateMoyensLivraisons(Long id, MoyensLivraisonsVo moyensLivraisonsVo);
	public List<MoyensLivraisonsVo> findByCommandes(CommandesVo commandesVo);
	public List<MoyensLivraisonsVo> findByMoyensLivraisons(String moyenLivraison);
}
