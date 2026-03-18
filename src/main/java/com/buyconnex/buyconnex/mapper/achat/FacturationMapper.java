package com.buyconnex.buyconnex.mapper.achat;

import com.buyconnex.buyconnex.entity.achat.Commandes;
import com.buyconnex.buyconnex.entity.achat.Facturations;
import com.buyconnex.buyconnex.mapper.client.AdresseMapper;
import com.buyconnex.buyconnex.vo.achat.FacturationsVo;

public class FacturationMapper {

	public static FacturationsVo toVO(Facturations facturations) {
		if(facturations == null) return null;
		FacturationsVo facturationsVo = new FacturationsVo();
		facturationsVo.setId(facturations.getFacturation_id());
		facturationsVo.setDateFacturation(facturations.getDateFacturation());
		facturationsVo.setDescription(facturations.getDescription());
		facturationsVo.setAdresses(AdresseMapper.toVO(facturations.getAdresses()));
		facturationsVo.setIdCommande(facturations.getCommandes() != null ? facturations.getCommandes().getCommande_id() : null);
		
		return facturationsVo;
	}
	
	public static Facturations toEntity(FacturationsVo facturationsVo) {
		if(facturationsVo == null) return null;
		Facturations facturations = new Facturations();
		facturations.setFacturation_id(facturationsVo.getId());
		facturations.setDateFacturation(facturationsVo.getDateFacturation());
		facturations.setDescription(facturationsVo.getDescription());
		facturations.setAdresses(AdresseMapper.toEntity(facturationsVo.getAdresses()));
		if (facturationsVo.getIdCommande() != null) {
	        Commandes cmd = new Commandes();
	        cmd.setCommande_id(facturationsVo.getIdCommande());
	        facturations.setCommandes(cmd);
	    } else {
	        facturations.setCommandes(null);
	    }
		
		return facturations;
	}
	
	public static void updateEntityFromVO(FacturationsVo facturationsVo, Facturations facturations) {
		facturations.setFacturation_id(facturationsVo.getId());
		facturations.setDateFacturation(facturationsVo.getDateFacturation());
		facturations.setDescription(facturationsVo.getDescription());
		facturations.setAdresses(AdresseMapper.toEntity(facturationsVo.getAdresses()));
		if (facturationsVo.getIdCommande() != null) {
	        Commandes cmd = new Commandes();
	        cmd.setCommande_id(facturationsVo.getIdCommande());
	        facturations.setCommandes(cmd);
	    } else {
	        facturations.setCommandes(null);
	    }
	}
}
