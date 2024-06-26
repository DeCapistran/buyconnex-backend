package com.buyconnex.buyconnex.mapper.user;

import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.mapper.article.AvisMapper;
import com.buyconnex.buyconnex.mapper.client.ClientMapper;
import com.buyconnex.buyconnex.mapper.client.PanierMapper;
import com.buyconnex.buyconnex.mapper.other.NewsletterMapper;
import com.buyconnex.buyconnex.vo.user.UsersVo;

public class UserMapper {

	public static UsersVo toVO(Users users) {
		UsersVo usersVo = new UsersVo();
		usersVo.setUsername(users.getUsername());
		usersVo.setEmail(users.getEmail());
		usersVo.setPassword(users.getPassword());
		usersVo.setFirstname(users.getFirstname());
		usersVo.setLastname(users.getLastname());
		usersVo.setDateCreation(users.getDateCreation());
		usersVo.setRoles(users.getRoles());
		usersVo.setNotifications(users.getNotifications().stream().map(NotificationMapper::toVO).collect(Collectors.toSet()));
		usersVo.setAvis(users.getAvis().stream().map(AvisMapper::toVO).collect(Collectors.toSet()));
		usersVo.setPaniers(PanierMapper.toVO(users.getPaniers()));
		usersVo.setClients(ClientMapper.toVO(users.getClients()));
		usersVo.setNewsletters(NewsletterMapper.toVO(users.getNewsletters()));
		
		return usersVo;
	}
	
	public static Users toEntity(UsersVo usersVo) {
		Users users = new Users();
		users.setUsername(usersVo.getUsername());
		users.setEmail(usersVo.getEmail());
		users.setPassword(usersVo.getPassword());
		users.setFirstname(usersVo.getFirstname());
		users.setLastname(usersVo.getLastname());
		users.setDateCreation(usersVo.getDateCreation());
		users.setRoles(usersVo.getRoles());
		users.setNotifications(usersVo.getNotifications().stream().map(NotificationMapper::toEntity).collect(Collectors.toSet()));
		users.setAvis(usersVo.getAvis().stream().map(AvisMapper::toEntity).collect(Collectors.toSet()));
		users.setPaniers(PanierMapper.toEntity(usersVo.getPaniers()));
		users.setClients(ClientMapper.toEntity(usersVo.getClients()));
		users.setNewsletters(NewsletterMapper.toEntity(usersVo.getNewsletters()));
		
		return users;
	}
	
	public static void updateEntityFromVO(UsersVo usersVo, Users users) {
		users.setUsername(usersVo.getUsername());
		users.setEmail(usersVo.getEmail());
		users.setPassword(usersVo.getPassword());
		users.setFirstname(usersVo.getFirstname());
		users.setLastname(usersVo.getLastname());
		users.setDateCreation(usersVo.getDateCreation());
		users.setRoles(usersVo.getRoles());
		users.setNotifications(usersVo.getNotifications().stream().map(NotificationMapper::toEntity).collect(Collectors.toSet()));
		users.setAvis(usersVo.getAvis().stream().map(AvisMapper::toEntity).collect(Collectors.toSet()));
		users.setPaniers(PanierMapper.toEntity(usersVo.getPaniers()));
		users.setClients(ClientMapper.toEntity(usersVo.getClients()));
		users.setNewsletters(NewsletterMapper.toEntity(usersVo.getNewsletters()));
	}
}
