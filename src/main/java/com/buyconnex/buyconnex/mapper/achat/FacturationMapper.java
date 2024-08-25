package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.mapper.client.AdresseMapper;
import com.buyconnex.buyconnex.vo.achat.FacturationsVo;

public class FacturationMapper {

	public static FacturationsVo toVO(Facturations facturations) {
		FacturationsVo facturationsVo = new FacturationsVo();
		facturationsVo.setId(facturations.getFacturation_id());
		facturationsVo.setDateFacturation(facturations.getDateFacturation());
		facturationsVo.setDescription(facturations.getDescription());
		facturationsVo.setCommandes(CommandeMapper.toVO(facturations.getCommandes()));
		facturationsVo.setAdresses(AdresseMapper.toVO(facturations.getAdresses()));
		
		return facturationsVo;
	}
	
	public static Facturations toEntity(FacturationsVo facturationsVo) {
		Facturations facturations = new Facturations();
		facturations.setFacturation_id(facturationsVo.getId());
		facturations.setDateFacturation(facturationsVo.getDateFacturation());
		facturations.setDescription(facturationsVo.getDescription());
		facturations.setCommandes(CommandeMapper.toEntity(facturationsVo.getCommandes()));
		facturations.setAdresses(AdresseMapper.toEntity(facturationsVo.getAdresses()));
		
		return facturations;
	}
	
	public static void updateEntityFromVO(FacturationsVo facturationsVo, Facturations facturations) {
		facturations.setFacturation_id(facturationsVo.getId());
		facturations.setDateFacturation(facturationsVo.getDateFacturation());
		facturations.setDescription(facturationsVo.getDescription());
		facturations.setCommandes(CommandeMapper.toEntity(facturationsVo.getCommandes()));
		facturations.setAdresses(AdresseMapper.toEntity(facturationsVo.getAdresses()));
	}
}
