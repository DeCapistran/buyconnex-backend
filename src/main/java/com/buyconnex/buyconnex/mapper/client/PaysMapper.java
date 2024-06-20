package com.buyconnex.buyconnex.mapper.client;

import com.buyconnex.buyconnex.entity.client.Pays;
import com.buyconnex.buyconnex.vo.client.PaysVo;

public class PaysMapper {

	public static PaysVo toVO(Pays pays) {
		PaysVo paysVo = new PaysVo();
		paysVo.setPays(pays.getPays());
		paysVo.setVilles(pays.getVilles());
		
		return paysVo;
	}
	
	public static Pays toEntity(PaysVo paysVo) {
		Pays pays = new Pays();
		pays.setPays(paysVo.getPays());
		pays.setVilles(paysVo.getVilles());
		
		return pays;
	}
}
