package com.buyconnex.buyconnex.mapper.client;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.vo.client.VillesVo;

public class VilleMapper {

	public static VillesVo toVO(Villes villes) {
		if(villes == null) return null;
		VillesVo villesVo = new VillesVo();
		villesVo.setId(villes.getVille_id());
		villesVo.setCommunes(villes.getCommunes().stream().map(CommuneMapper::toVO).collect(Collectors.toSet()));
		villesVo.setIdPays(villes.getPays().getPays_id());
		villesVo.setVille(villes.getVille());
		
		return villesVo;
	}
	
	public static Villes toEntity(VillesVo villesVo) {
		if(villesVo == null) return null;
		Villes villes = new Villes();
		villes.setVille_id(villesVo.getId());
		villes.setCommunes(villesVo.getCommunes().stream().map(CommuneMapper::toEntity).collect(Collectors.toSet()));
		villes.setVille(villesVo.getVille());
		if (villesVo.getIdPays() != null) {
	        Pays paysRef = new Pays();
	        paysRef.setPays_id(villesVo.getIdPays());
	        villes.setPays(paysRef);
	    } else {
	    	villes.setPays(null);
	    }
		
		return villes;
	}
	
	public static void updateEntityFromVO(VillesVo villesVo, Villes villes) {
		villes.setVille_id(villesVo.getId());
		villes.setCommunes(villesVo.getCommunes().stream().map(CommuneMapper::toEntity).collect(Collectors.toSet()));
		villes.setVille(villesVo.getVille());
		if (villesVo.getIdPays() != null) {
	        Pays paysRef = new Pays();
	        paysRef.setPays_id(villesVo.getIdPays());
	        villes.setPays(paysRef);
	    } else {
	    	villes.setPays(null);
	    }
	}
	
	public static VillesVo toVO_Simple(Villes villes) {
	    if (villes == null) return null;
	    VillesVo villesVo = new VillesVo();
	    villesVo.setId(villes.getVille_id());
	    villesVo.setVille(villes.getVille());
	    villesVo.setIdPays(villes.getPays() != null ? villes.getPays().getPays_id() : null);
	    villesVo.setCommunes(null); // IMPORTANT
	    return villesVo;
	}
}
