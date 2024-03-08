package com.buyconnex.buyconnex.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import com.buyconnex.buyconnex.entity.user.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userService.findUserByUsername(username);
		
	if (user==null) 
	    throw new UsernameNotFoundException("Utilisateur introuvable !");
		
		List<GrantedAuthority> auths = new ArrayList<>();
		
		 user.getRoles().forEach(role -> {
			 GrantedAuthority auhority = new SimpleGrantedAuthority(role.getRole());
			 auths.add(auhority);
		 });
		
		return new org.springframework.security.core.
				userdetails.User(user.getUsername(),user.getPassword(),user.isBActivated() ,true, true, true, auths);
	  }
}
