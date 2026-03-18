package com.buyconnex.buyconnex.mapper.client;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.vo.client.PaysVo;

public class PaysMapper {

	public static PaysVo toVO(Pays pays) {
		if(pays == null) return null;
		PaysVo paysVo = new PaysVo();
		paysVo.setId(pays.getPays_id());
		paysVo.setPays(pays.getPays());
		paysVo.setVilles(pays.getVilles().stream().map(VilleMapper::toVO).collect(Collectors.toSet()));
		
		return paysVo;
	}
	
	public static Pays toEntity(PaysVo paysVo) {
		if(paysVo == null) return null;
		Pays pays = new Pays();
		pays.setPays_id(paysVo.getId());
		pays.setPays(paysVo.getPays());
		pays.setVilles(paysVo.getVilles().stream().map(VilleMapper::toEntity).collect(Collectors.toSet()));
		
		return pays;
	}
	
	public static void updateEntityFromVO(PaysVo paysVo, Pays pays) {
		pays.setPays_id(paysVo.getId());
		pays.setPays(paysVo.getPays());
		pays.setVilles(paysVo.getVilles().stream().map(VilleMapper::toEntity).collect(Collectors.toSet()));
	}
	
	public static PaysVo toVO_Simple(Pays pays) {
	    if (pays == null) return null;
	    PaysVo paysVo = new PaysVo();
	    paysVo.setId(pays.getPays_id());
	    paysVo.setPays(pays.getPays());
	    paysVo.setVilles(null); // IMPORTANT
	    return paysVo;
	}
}
