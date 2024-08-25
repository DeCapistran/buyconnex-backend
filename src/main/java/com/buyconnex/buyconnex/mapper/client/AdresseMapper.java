package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Adresses;
import com.buyconnex.buyconnex.mapper.achat.FacturationMapper;
import com.buyconnex.buyconnex.mapper.achat.LivraisonMapper;
import com.buyconnex.buyconnex.vo.client.AdresseVo;

public class AdresseMapper {

	public static AdresseVo toVO(Adresses adresses) {
		AdresseVo adresseVo = new AdresseVo();
		adresseVo.setId(adresses.getAdresse_id());
		adresseVo.setAdresse1(adresses.getAdresse1());
		adresseVo.setAdresse2(adresses.getAdresse2());
		adresseVo.setCodePostal(adresses.getCodePostal());
		adresseVo.setDescription(adresses.getDescription());
		adresseVo.setPays(PaysMapper.toVO(adresses.getPays()));
		adresseVo.setVilles(VilleMapper.toVO(adresses.getVille()));
		adresseVo.setCommunes(CommuneMapper.toVO(adresses.getCommune()));
		adresseVo.setClients(ClientMapper.toVO(adresses.getClients()));
		adresseVo.setFacturations(FacturationMapper.toVO(adresses.getFacturations()));
		adresseVo.setLivraisons(LivraisonMapper.toVO(adresses.getLivraisons()));
		
		return adresseVo;
	}
	
	public static Adresses toEntity(AdresseVo adressesVo) {
		Adresses adresses = new Adresses();
		adresses.setAdresse_id(adressesVo.getId());
		adresses.setAdresse1(adressesVo.getAdresse1());
		adresses.setAdresse2(adressesVo.getAdresse2());
		adresses.setCodePostal(adressesVo.getCodePostal());
		adresses.setDescription(adressesVo.getDescription());
		adresses.setPays(PaysMapper.toEntity(adressesVo.getPays()));
		adresses.setVille(VilleMapper.toEntity(adressesVo.getVilles()));
		adresses.setCommune(CommuneMapper.toEntity(adressesVo.getCommunes()));
		adresses.setClients(ClientMapper.toEntity(adressesVo.getClients()));
		adresses.setFacturations(FacturationMapper.toEntity(adressesVo.getFacturations()));
		adresses.setLivraisons(LivraisonMapper.toEntity(adressesVo.getLivraisons()));
		
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
		adresses.setClients(ClientMapper.toEntity(adressesVo.getClients()));
		adresses.setFacturations(FacturationMapper.toEntity(adressesVo.getFacturations()));
		adresses.setLivraisons(LivraisonMapper.toEntity(adressesVo.getLivraisons()));
	}
}
