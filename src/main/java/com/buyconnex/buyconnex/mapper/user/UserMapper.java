package com.buyconnex.buyconnex.mapper.user;

import java.util.Collections;
import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.mapper.article.AvisMapper;
import com.buyconnex.buyconnex.mapper.client.PanierMapper;
import com.buyconnex.buyconnex.mapper.other.NewsletterMapper;
import com.buyconnex.buyconnex.vo.user.UsersVo;

public class UserMapper {

	public static UsersVo toVO(Users users) {
		if(users == null) return null;
		UsersVo usersVo = new UsersVo();
		usersVo.setId(users.getUser_id());
		usersVo.setUsername(users.getUsername());
		usersVo.setEmail(users.getEmail());
		usersVo.setPassword(users.getPassword());
		usersVo.setFirstname(users.getFirstname());
		usersVo.setLastname(users.getLastname());
		usersVo.setDateCreation(users.getDateCreation());
		usersVo.setRoles(users.getRoles());
		usersVo.setNotifications(
		        users.getNotifications() == null ? Collections.emptySet()
		            : users.getNotifications().stream().map(NotificationMapper::toVO).collect(Collectors.toSet()));
		usersVo.setAvis(users.getAvis() == null ? Collections.emptySet()
		        : users.getAvis().stream().map(AvisMapper::toVO).collect(Collectors.toSet()));
		usersVo.setPaniers(PanierMapper.toVO(users.getPaniers()));
		usersVo.setNewsletters(NewsletterMapper.toVO(users.getNewsletters()));
		
		return usersVo;
	}
	
	public static Users toEntity(UsersVo usersVo) {
		if(usersVo == null) return null;
		Users users = new Users();
		users.setUser_id(usersVo.getId());
		users.setUsername(usersVo.getUsername());
		users.setEmail(usersVo.getEmail());
		users.setPassword(usersVo.getPassword());
		users.setFirstname(usersVo.getFirstname());
		users.setLastname(usersVo.getLastname());
		users.setDateCreation(usersVo.getDateCreation());
		users.setRoles(usersVo.getRoles());
		users.setNotifications(usersVo.getNotifications() == null ? Collections.emptySet()
		        : usersVo.getNotifications().stream().map(NotificationMapper::toEntity).collect(Collectors.toSet()));
		users.setAvis(usersVo.getAvis() == null ? Collections.emptySet()
		        : usersVo.getAvis().stream().map(AvisMapper::toEntity).collect(Collectors.toSet()));
		users.setPaniers(PanierMapper.toEntity(usersVo.getPaniers()));
		users.setNewsletters(NewsletterMapper.toEntity(usersVo.getNewsletters()));
		
		return users;
	}
	
	public static void updateEntityFromVO(UsersVo usersVo, Users users) {
		users.setUser_id(usersVo.getId());
		users.setUsername(usersVo.getUsername());
		users.setEmail(usersVo.getEmail());
		users.setPassword(usersVo.getPassword());
		users.setFirstname(usersVo.getFirstname());
		users.setLastname(usersVo.getLastname());
		users.setDateCreation(usersVo.getDateCreation());
		users.setRoles(usersVo.getRoles());
		users.setNotifications(usersVo.getNotifications() == null ? Collections.emptySet()
		        : usersVo.getNotifications().stream().map(NotificationMapper::toEntity).collect(Collectors.toSet()));
		users.setAvis(usersVo.getAvis() == null ? Collections.emptySet()
		        : usersVo.getAvis().stream().map(AvisMapper::toEntity).collect(Collectors.toSet()));
		users.setPaniers(PanierMapper.toEntity(usersVo.getPaniers()));
		users.setNewsletters(NewsletterMapper.toEntity(usersVo.getNewsletters()));
	}
}
