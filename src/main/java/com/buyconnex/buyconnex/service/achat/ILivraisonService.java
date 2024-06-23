package com.buyconnex.buyconnex.service.achat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;
import com.buyconnex.buyconnex.vo.achat.StatusLivraisonsVo;
import com.buyconnex.buyconnex.vo.client.AdresseVo;

public interface ILivraisonService {

	public Optional<LivraisonsVo> findById(Long id);
	public LivraisonsVo saveLivraisons(LivraisonsVo livraisonsVo);
	public void deleteLivraisons(LivraisonsVo livraisonsVo);
	public LivraisonsVo updateLivraisons(Long id, LivraisonsVo livraisonsVo);
	public List<LivraisonsVo> findByCommandes(CommandesVo commandesVo);
	public List<LivraisonsVo> findByAdresses(AdresseVo adressesVo);
	public List<LivraisonsVo> findByDateLivraisons(Date date);
	public LivraisonsVo findByNumeroLivraisons(String numeroLivraison);
	public List<LivraisonsVo> findByStatusLivraisons(StatusLivraisonsVo statusLivraisonsVo);
}
