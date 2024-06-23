package com.buyconnex.buyconnex.service.achat;

import java.util.List;
import java.util.Optional;

import com.buyconnex.buyconnex.vo.achat.LivraisonsVo;
import com.buyconnex.buyconnex.vo.achat.StatusLivraisonsVo;

public interface IStatusLivraisonService {

	public Optional<StatusLivraisonsVo> findById(Long id);
	public StatusLivraisonsVo saveStatusLivraisons(StatusLivraisonsVo statusLivraisonsVo);
	public void deleteStatusLivraison(StatusLivraisonsVo statusLivraisonsVo);
	public StatusLivraisonsVo updateStatusLivraisons(Long id, StatusLivraisonsVo statusLivraisonsVo);
	public List<StatusLivraisonsVo> findByLivraisons(LivraisonsVo livraisonsVo);
	public List<StatusLivraisonsVo> findByStatus(String status);
}
