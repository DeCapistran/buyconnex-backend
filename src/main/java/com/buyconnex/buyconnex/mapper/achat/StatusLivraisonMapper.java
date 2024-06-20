package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.vo.achat.StatusLivraisonsVo;

public class StatusLivraisonMapper {

	public static StatusLivraisonsVo toVO(StatusLivraisons statusLivraisons) {
		StatusLivraisonsVo statusLivraisonsVo = new StatusLivraisonsVo();
		statusLivraisonsVo.setDescription(statusLivraisons.getDescription());
		statusLivraisonsVo.setLivraisons(statusLivraisons.getLivraisons());
		statusLivraisonsVo.setStatus(statusLivraisons.getStatus());
		
		return statusLivraisonsVo;
	}
	
	public static StatusLivraisons toEntity(StatusLivraisonsVo statusLivraisonsVo) {
		StatusLivraisons statusLivraisons = new StatusLivraisons();
		statusLivraisons.setDescription(statusLivraisonsVo.getDescription());
		statusLivraisons.setLivraisons(statusLivraisonsVo.getLivraisons());
		statusLivraisons.setStatus(statusLivraisonsVo.getStatus());
		
		return statusLivraisons;
	}
}
