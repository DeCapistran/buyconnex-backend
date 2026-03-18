package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.CommandesVo;
import com.buyconnex.buyconnex.vo.achat.LivraisonsDetailsVo;
import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;

public interface ILivraisonDetailService {

	public Optional<LivraisonsDetailsVo> findById(Long id);
	public List<LivraisonsDetailsVo> findAll();
	public LivraisonsDetailsVo saveLivraisonsDetails(LivraisonsDetailsVo livraisonsDetailsVo);
	public void deleteLivraisonsDetails(LivraisonsDetailsVo livraisonsDetailsVo);
	public void deleteLivraisonsDetailsById(Long id);
	public LivraisonsDetailsVo updateLivraisonsDetails(Long id, LivraisonsDetailsVo livraisonsDetailsVo);
	public List<LivraisonsDetailsVo> findByCommandes(CommandesVo commandesVo);
	public List<LivraisonsDetailsVo> findByLivraisons(LivraisonsVo livraisonsVo);
}
