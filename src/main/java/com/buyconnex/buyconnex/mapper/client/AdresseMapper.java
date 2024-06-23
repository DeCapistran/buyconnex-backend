package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.vo.client.AdresseVo;

public class AdresseMapper {

	public static AdresseVo toVO(Adresses adresses) {
		AdresseVo adresseVo = new AdresseVo();
		adresseVo.setPays(adresses.getPays());
		adresseVo.setVilles(adresses.getVille());
		adresseVo.setCommunes(adresses.getCommune());
		adresseVo.setAdresse1(adresses.getAdresse1());
		adresseVo.setAdresse2(adresses.getAdresse2());
		adresseVo.setCodePostal(adresses.getCodePostal());
		adresseVo.setDescription(adresses.getDescription());
		adresseVo.setClients(adresses.getClients());
		adresseVo.setFacturations(adresses.getFacturations());
		adresseVo.setLivraisons(adresses.getLivraisons());
		
		return adresseVo;
	}
	
	public static Adresses toEntity(AdresseVo adressesVo) {
		Adresses adresses = new Adresses();
		adresses.setPays(adressesVo.getPays());
		adresses.setVille(adressesVo.getVilles());
		adresses.setCommune(adressesVo.getCommunes());
		adresses.setAdresse1(adressesVo.getAdresse1());
		adresses.setAdresse2(adressesVo.getAdresse2());
		adresses.setCodePostal(adressesVo.getCodePostal());
		adresses.setDescription(adressesVo.getDescription());
		adresses.setClients(adressesVo.getClients());
		adresses.setFacturations(adressesVo.getFacturations());
		adresses.setLivraisons(adressesVo.getLivraisons());
		
		return adresses;
	}
	
	public static void updateEntityFromVO(AdresseVo adressesVo, Adresses adresses) {
		
		adresses.setPays(adressesVo.getPays());
		adresses.setVille(adressesVo.getVilles());
		adresses.setCommune(adressesVo.getCommunes());
		adresses.setAdresse1(adressesVo.getAdresse1());
		adresses.setAdresse2(adressesVo.getAdresse2());
		adresses.setCodePostal(adressesVo.getCodePostal());
		adresses.setDescription(adressesVo.getDescription());
		adresses.setClients(adressesVo.getClients());
		adresses.setFacturations(adressesVo.getFacturations());
		adresses.setLivraisons(adressesVo.getLivraisons());
	}
}
