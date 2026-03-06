package com.buyconnex.buyconnex.mapper.other;

import com.buyconnex.buyconnex.entity.others.Newsletters;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.other.NewslettersVo;

public class NewsletterMapper {

	public static NewslettersVo toVO(Newsletters newsletters) {
		if(newsletters == null) return null;
		NewslettersVo newslettersVo = new NewslettersVo();
		newslettersVo.setId(newsletters.getNewletter_id());
		newslettersVo.setDateInscription(newsletters.getDateInscription());
		newslettersVo.setDateDesincription(newsletters.getDateDesinscription());
		newslettersVo.setEmail(newsletters.getEmail());
		newslettersVo.setUsers(UserMapper.toVO(newsletters.getUsers()));
		
		return newslettersVo;
	}
	
	public static Newsletters toEntity(NewslettersVo newslettersVo) {
		if(newslettersVo == null) return null;
		Newsletters newsletters = new Newsletters();
		newsletters.setNewletter_id(newslettersVo.getId());
		newsletters.setDateInscription(newslettersVo.getDateInscription());
		newsletters.setDateDesinscription(newslettersVo.getDateDesincription());
		newsletters.setEmail(newslettersVo.getEmail());
		newsletters.setUsers(UserMapper.toEntity(newslettersVo.getUsers()));
		
		return newsletters;
	}
	
	public static void updateEntityFromVO(NewslettersVo newslettersVo, Newsletters newsletters) {
		newsletters.setNewletter_id(newslettersVo.getId());
		newsletters.setDateInscription(newslettersVo.getDateInscription());
		newsletters.setDateDesinscription(newslettersVo.getDateDesincription());
		newsletters.setEmail(newslettersVo.getEmail());
		newsletters.setUsers(UserMapper.toEntity(newslettersVo.getUsers()));
	}
}
