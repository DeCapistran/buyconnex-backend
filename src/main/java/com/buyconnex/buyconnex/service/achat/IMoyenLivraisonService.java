package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.MoyensLivraisons;

public interface IMoyenLivraisonService {

	public Optional<MoyensLivraisons> findByid(Long id);
	public MoyensLivraisons saveMoyensLivraisons(MoyensLivraisons moyensLivraisons);
	public void deleteMoyensLivraisons(MoyensLivraisons moyensLivraisons);
	public MoyensLivraisons updateMoyensLivraisons(MoyensLivraisons moyensLivraisons);
	public List<MoyensLivraisons> findByCommandes(Commandes commandes);
	public List<MoyensLivraisons> findByMoyensLivraisons(String moyenLivraison);
}
