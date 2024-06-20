package com.buyconnex.buyconnex.mapper.visuel;

import com.buyconnex.buyconnex.entity.visuel.Footers;
import com.buyconnex.buyconnex.vo.visuel.FootersVo;

public class FooterMapper {

	public static FootersVo toVO(Footers footers) {
		FootersVo footersVo = new FootersVo();
		footersVo.setAdresse(footers.getAdresse());
		footersVo.setMailSupport(footers.getMailSupport());
		footersVo.setTelephone(footers.getTelephone());
		
		return footersVo;
	}
	
	public static Footers toEntity(FootersVo footersVo) {
		Footers footers = new Footers();
		footers.setAdresse(footersVo.getAdresse());
		footers.setMailSupport(footersVo.getMailSupport());
		footers.setTelephone(footersVo.getTelephone());
		
		return footers;
	}
}
