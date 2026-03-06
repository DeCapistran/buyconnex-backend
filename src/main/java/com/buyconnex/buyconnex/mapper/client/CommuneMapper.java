package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.vo.client.CommunesVo;

public class CommuneMapper {

	public static CommunesVo toVO(Communes communes) {
		if(communes == null) return null;
		CommunesVo communesVo = new CommunesVo();
		communesVo.setId(communes.getCommune_id());
		communesVo.setCommune(communes.getCommune());
		communesVo.setIdVille(communes.getVilles().getVille_id());
		
		return communesVo;
	}
	
	public static Communes toEntity(CommunesVo communesVo) {
		if(communesVo == null) return null;
		Communes communes = new Communes();
		communes.setCommune_id(communesVo.getId());
		communes.setCommune(communesVo.getCommune());
		if (communesVo.getIdVille() != null) {
	        Villes villeRef = new Villes();
	        villeRef.setVille_id(communesVo.getIdVille());
	        communes.setVilles(villeRef);
	    } else {
	        communes.setVilles(null);
	    }
		
		return communes;
	}
	
	public static void updateEntityFromVO(CommunesVo communesVo, Communes communes) {
		communes.setCommune_id(communesVo.getId());
		communes.setCommune(communesVo.getCommune());
		if (communesVo.getIdVille() != null) {
	        Villes villeRef = new Villes();
	        villeRef.setVille_id(communesVo.getIdVille());
	        communes.setVilles(villeRef);
	    } else {
	        communes.setVilles(null);
	    }
	}
}
