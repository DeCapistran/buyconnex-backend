package com.buyconnex.buyconnex.mapper.user;

import com.buyconnex.buyconnex.entity.user.Users;
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
		usersVo.setNotifications(users.getNotifications());
		usersVo.setAvis(users.getAvis());
		usersVo.setPaniers(users.getPaniers());
		usersVo.setClients(users.getClients());
		usersVo.setNewsletters(users.getNewsletters());
		
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
		users.setNotifications(usersVo.getNotifications());
		users.setAvis(usersVo.getAvis());
		users.setPaniers(usersVo.getPaniers());
		users.setClients(usersVo.getClients());
		users.setNewsletters(usersVo.getNewsletters());
		
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
		users.setNotifications(usersVo.getNotifications());
		users.setAvis(usersVo.getAvis());
		users.setPaniers(usersVo.getPaniers());
		users.setClients(usersVo.getClients());
		users.setNewsletters(usersVo.getNewsletters());
	}
}
