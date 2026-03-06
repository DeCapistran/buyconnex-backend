package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.vo.client.AdresseVo;

public class AdresseMapper {

	public static AdresseVo toVO(Adresses adresses) {
		if(adresses == null) return null;
		AdresseVo adresseVo = new AdresseVo();
		adresseVo.setId(adresses.getAdresse_id());
		adresseVo.setAdresse1(adresses.getAdresse1());
		adresseVo.setAdresse2(adresses.getAdresse2());
		adresseVo.setCodePostal(adresses.getCodePostal());
		adresseVo.setDescription(adresses.getDescription());
		adresseVo.setPays(PaysMapper.toVO_Simple(adresses.getPays()));
		adresseVo.setVilles(VilleMapper.toVO_Simple(adresses.getVille()));
		adresseVo.setCommunes(CommuneMapper.toVO(adresses.getCommune()));
		
		return adresseVo;
	}
	
	public static Adresses toEntity(AdresseVo adressesVo) {
		if(adressesVo == null) return null;
		Adresses adresses = new Adresses();
		adresses.setAdresse_id(adressesVo.getId());
		adresses.setAdresse1(adressesVo.getAdresse1());
		adresses.setAdresse2(adressesVo.getAdresse2());
		adresses.setCodePostal(adressesVo.getCodePostal());
		adresses.setDescription(adressesVo.getDescription());
		adresses.setPays(PaysMapper.toEntity(adressesVo.getPays()));
		adresses.setVille(VilleMapper.toEntity(adressesVo.getVilles()));
		adresses.setCommune(CommuneMapper.toEntity(adressesVo.getCommunes()));
		
		return adresses;
	}
	
	public static void updateEntityFromVO(AdresseVo adressesVo, Adresses adresses) {
		adresses.setAdresse_id(adressesVo.getId());
		adresses.setAdresse1(adressesVo.getAdresse1());
		adresses.setAdresse2(adressesVo.getAdresse2());
		adresses.setCodePostal(adressesVo.getCodePostal());
		adresses.setDescription(adressesVo.getDescription());
		adresses.setPays(PaysMapper.toEntity(adressesVo.getPays()));
		adresses.setVille(VilleMapper.toEntity(adressesVo.getVilles()));
		adresses.setCommune(CommuneMapper.toEntity(adressesVo.getCommunes()));
	}
}
