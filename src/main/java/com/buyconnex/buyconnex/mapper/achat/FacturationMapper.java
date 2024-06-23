package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.vo.achat.FacturationsVo;

public class FacturationMapper {

	public static FacturationsVo toVO(Facturations facturations) {
		FacturationsVo facturationsVo = new FacturationsVo();
		facturationsVo.setDateFacturation(facturations.getDateFacturation());
		facturationsVo.setDescription(facturations.getDescription());
		facturationsVo.setCommandes(facturations.getCommandes());
		facturationsVo.setAdresses(facturations.getAdresses());
		
		return facturationsVo;
	}
	
	public static Facturations toEntity(FacturationsVo facturationsVo) {
		Facturations facturations = new Facturations();
		facturations.setDateFacturation(facturationsVo.getDateFacturation());
		facturations.setDescription(facturationsVo.getDescription());
		facturations.setCommandes(facturationsVo.getCommandes());
		facturations.setAdresses(facturationsVo.getAdresses());
		
		return facturations;
	}
	
	public static void updateEntityFromVO(FacturationsVo facturationsVo, Facturations facturations) {
		
		facturations.setDateFacturation(facturationsVo.getDateFacturation());
		facturations.setDescription(facturationsVo.getDescription());
		facturations.setCommandes(facturationsVo.getCommandes());
		facturations.setAdresses(facturationsVo.getAdresses());
	}
}
