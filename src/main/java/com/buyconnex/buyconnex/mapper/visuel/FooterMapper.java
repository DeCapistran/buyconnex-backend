package com.buyconnex.buyconnex.mapper.visuel;

import com.buyconnex.buyconnex.entity.visuel.Footers;
import com.buyconnex.buyconnex.vo.visuel.FootersVo;

public class FooterMapper {

	public static FootersVo toVO(Footers footers) {
		if(footers == null) return null;
		FootersVo footersVo = new FootersVo();
		footersVo.setId(footers.getFooter_id());
		footersVo.setAdresse(footers.getAdresse());
		footersVo.setMailSupport(footers.getMailSupport());
		footersVo.setTelephone(footers.getTelephone());
		
		return footersVo;
	}
	
	public static Footers toEntity(FootersVo footersVo) {
		if(footersVo == null) return null;
		Footers footers = new Footers();
		footers.setFooter_id(footersVo.getId());
		footers.setAdresse(footersVo.getAdresse());
		footers.setMailSupport(footersVo.getMailSupport());
		footers.setTelephone(footersVo.getTelephone());
		
		return footers;
	}
	
	public static void updateEntityFromVO(FootersVo footersVo, Footers footers) {
		footers.setFooter_id(footersVo.getId());
		footers.setAdresse(footersVo.getAdresse());
		footers.setMailSupport(footersVo.getMailSupport());
		footers.setTelephone(footersVo.getTelephone());
	}
}
