package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Communes;
import com.buyconnex.buyconnex.vo.client.CommunesVo;

public class CommuneMapper {

	public static CommunesVo toVO(Communes communes) {
		CommunesVo communesVo = new CommunesVo();
		communesVo.setCommune(communes.getCommune());
		communesVo.setVilles(communes.getVilles());
		
		return communesVo;
	}
	
	public static Communes toEntity(CommunesVo communesVo) {
		Communes communes = new Communes();
		communes.setCommune(communesVo.getCommune());
		communes.setVilles(communesVo.getVilles());
		
		return communes;
	}
}
