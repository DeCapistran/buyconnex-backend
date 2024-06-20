package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;

public class StatusCommandeMapper {

	public static StatusCommandesVo toVO(StatusCommandes statusCommandes) {
		StatusCommandesVo statusCommandesVo = new StatusCommandesVo();
		statusCommandesVo.setCommandes(statusCommandes.getCommandes());
		statusCommandesVo.setDescription(statusCommandes.getDescription());
		statusCommandesVo.setStatus(statusCommandes.getStatus());
		
		return statusCommandesVo;
	}
	
	public static StatusCommandes toEntity(StatusCommandesVo statusCommandesVo) {
		StatusCommandes statusCommandes = new StatusCommandes();
		statusCommandes.setCommandes(statusCommandesVo.getCommandes());
		statusCommandes.setDescription(statusCommandesVo.getDescription());
		statusCommandes.setStatus(statusCommandesVo.getStatus());
		
		return statusCommandes;
	}
}
