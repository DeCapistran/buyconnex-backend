package com.buyconnex.buyconnex.mapper.achat;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.achat.StatusCommandes;
import com.buyconnex.buyconnex.vo.achat.StatusCommandesVo;

public class StatusCommandeMapper {

	public static StatusCommandesVo toVO(StatusCommandes statusCommandes) {
		StatusCommandesVo statusCommandesVo = new StatusCommandesVo();
		statusCommandesVo.setCommandes(statusCommandes.getCommandes().stream().map(CommandeMapper::toVO).collect(Collectors.toSet()));
		statusCommandesVo.setDescription(statusCommandes.getDescription());
		statusCommandesVo.setStatus(statusCommandes.getStatus());
		
		return statusCommandesVo;
	}
	
	public static StatusCommandes toEntity(StatusCommandesVo statusCommandesVo) {
		StatusCommandes statusCommandes = new StatusCommandes();
		statusCommandes.setCommandes(statusCommandesVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		statusCommandes.setDescription(statusCommandesVo.getDescription());
		statusCommandes.setStatus(statusCommandesVo.getStatus());
		
		return statusCommandes;
	}
	
	public static void updateEntityFromVO(StatusCommandesVo statusCommandesVo, StatusCommandes statusCommandes) {
		
		statusCommandes.setCommandes(statusCommandesVo.getCommandes().stream().map(CommandeMapper::toEntity).collect(Collectors.toSet()));
		statusCommandes.setDescription(statusCommandesVo.getDescription());
		statusCommandes.setStatus(statusCommandesVo.getStatus());
	}
}
