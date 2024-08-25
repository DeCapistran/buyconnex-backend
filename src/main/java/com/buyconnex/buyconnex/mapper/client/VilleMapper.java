package com.buyconnex.buyconnex.mapper.client;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.client.Villes;
import com.buyconnex.buyconnex.vo.client.VillesVo;

public class VilleMapper {

	public static VillesVo toVO(Villes villes) {
		VillesVo villesVo = new VillesVo();
		villesVo.setId(villes.getVille_id());
		villesVo.setCommunes(villes.getCommunes().stream().map(CommuneMapper::toVO).collect(Collectors.toSet()));
		villesVo.setPays(PaysMapper.toVO(villes.getPays()));
		villesVo.setVille(villes.getVille());
		
		return villesVo;
	}
	
	public static Villes toEntity(VillesVo villesVo) {
		Villes villes = new Villes();
		villes.setVille_id(villesVo.getId());
		villes.setCommunes(villesVo.getCommunes().stream().map(CommuneMapper::toEntity).collect(Collectors.toSet()));
		villes.setPays(PaysMapper.toEntity(villesVo.getPays()));
		villes.setVille(villesVo.getVille());
		
		return villes;
	}
	
	public static void updateEntityFromVO(VillesVo villesVo, Villes villes) {
		villes.setVille_id(villesVo.getId());
		villes.setCommunes(villesVo.getCommunes().stream().map(CommuneMapper::toEntity).collect(Collectors.toSet()));
		villes.setPays(PaysMapper.toEntity(villesVo.getPays()));
		villes.setVille(villesVo.getVille());
	}
}
