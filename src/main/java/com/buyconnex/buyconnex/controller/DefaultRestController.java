package com.buyconnex.buyconnex.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.service.user.IUserService;

public class DefaultRestController {

	@Autowired
	protected MessageSource messages;
	
	@Autowired
	protected IUserService userService;
	
	protected Optional<Users> getUser(Principal principal) {
		return userService.findUserByEmail(principal.getName());
	}
}
