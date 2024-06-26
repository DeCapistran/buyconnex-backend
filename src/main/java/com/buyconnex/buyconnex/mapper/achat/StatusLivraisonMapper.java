package com.buyconnex.buyconnex.mapper.achat;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.StatusLivraisons;
import com.buyconnex.buyconnex.vo.achat.StatusLivraisonsVo;

public class StatusLivraisonMapper {

	public static StatusLivraisonsVo toVO(StatusLivraisons statusLivraisons) {
		StatusLivraisonsVo statusLivraisonsVo = new StatusLivraisonsVo();
		statusLivraisonsVo.setDescription(statusLivraisons.getDescription());
		statusLivraisonsVo.setLivraisons(statusLivraisons.getLivraisons().stream().map(LivraisonMapper::toVO).collect(Collectors.toSet()));
		statusLivraisonsVo.setStatus(statusLivraisons.getStatus());
		
		return statusLivraisonsVo;
	}
	
	public static StatusLivraisons toEntity(StatusLivraisonsVo statusLivraisonsVo) {
		StatusLivraisons statusLivraisons = new StatusLivraisons();
		statusLivraisons.setDescription(statusLivraisonsVo.getDescription());
		statusLivraisons.setLivraisons(statusLivraisonsVo.getLivraisons().stream().map(LivraisonMapper::toEntity).collect(Collectors.toSet()));
		statusLivraisons.setStatus(statusLivraisonsVo.getStatus());
		
		return statusLivraisons;
	}
	
	public static void updateEntityFromVO(StatusLivraisonsVo statusLivraisonsVo, StatusLivraisons statusLivraisons) {
		
		statusLivraisons.setDescription(statusLivraisonsVo.getDescription());
		statusLivraisons.setLivraisons(statusLivraisonsVo.getLivraisons().stream().map(LivraisonMapper::toEntity).collect(Collectors.toSet()));
		statusLivraisons.setStatus(statusLivraisonsVo.getStatus());
	}
}
