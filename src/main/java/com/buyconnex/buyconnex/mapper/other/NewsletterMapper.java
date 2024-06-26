package com.buyconnex.buyconnex.mapper.other;

import com.buyconnex.buyconnex.entity.others.Newsletters;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.other.NewslettersVo;

public class NewsletterMapper {

	public static NewslettersVo toVO(Newsletters newsletters) {
		NewslettersVo newslettersVo = new NewslettersVo();
		newslettersVo.setDateInscription(newsletters.getDateDesinscription());
		newslettersVo.setDateDesincription(newsletters.getDateDesinscription());
		newslettersVo.setEmail(newsletters.getEmail());
		newslettersVo.setUsers(UserMapper.toVO(newsletters.getUsers()));
		
		return newslettersVo;
	}
	
	public static Newsletters toEntity(NewslettersVo newslettersVo) {
		Newsletters newsletters = new Newsletters();
		newsletters.setDateInscription(newslettersVo.getDateInscription());
		newsletters.setDateDesinscription(newslettersVo.getDateDesincription());
		newsletters.setEmail(newslettersVo.getEmail());
		newsletters.setUsers(UserMapper.toEntity(newslettersVo.getUsers()));
		
		return newsletters;
	}
	
	public static void updateEntityFromVO(NewslettersVo newslettersVo, Newsletters newsletters) {
		
		newsletters.setDateInscription(newslettersVo.getDateInscription());
		newsletters.setDateDesinscription(newslettersVo.getDateDesincription());
		newsletters.setEmail(newslettersVo.getEmail());
		newsletters.setUsers(UserMapper.toEntity(newslettersVo.getUsers()));
	}
}
