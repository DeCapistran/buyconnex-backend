package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.vo.client.VillesVo;

public class VilleMapper {

	public static VillesVo toVO(Villes villes) {
		VillesVo villesVo = new VillesVo();
		villesVo.setCommunes(villes.getCommunes());
		villesVo.setPays(villes.getPays());
		villesVo.setVille(villes.getVille());
		
		return villesVo;
	}
	
	public static Villes toEntity(VillesVo villesVo) {
		Villes villes = new Villes();
		villes.setCommunes(villesVo.getCommunes());
		villes.setPays(villesVo.getPays());
		villes.setVille(villesVo.getVille());
		
		return villes;
	}
}
