package com.buyconnex.buyconnex.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.exception.ConnexionException;
import com.buyconnex.buyconnex.repository.user.UserRepository;
import com.buyconnex.buyconnex.vo.user.AuthRequestVo;
import com.buyconnex.buyconnex.vo.user.AuthResponseVo;

@Service
public class AuthenticationService {

	@Autowired
	AuthenticationManager authenticationManager;
    
    @Autowired
    UserRepository userRepository;
   

    
    @SuppressWarnings("unlikely-arg-type")
	public AuthResponseVo authenticate(AuthRequestVo request) {   
    	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
             
        Users user = userRepository.findByUsername(request.getUsername());
                        
        List<String> roles = new ArrayList<>();
        user.getRoles().forEach(r-> {
			roles.add(r.getRole());
		});
		
		
		String jwt = JWT.create().
				  withSubject(user.getUsername()).
		withArrayClaim("roles", roles.toArray(new String[roles.size()])).
		withExpiresAt(new Date(System.currentTimeMillis()+SecParams.EXP_TIME)). 
		sign(Algorithm.HMAC256(SecParams.SECRET));
		
		if(AuthResponseVo.builder().token(jwt).username(user.getUsername()).build().equals(HttpStatus.FORBIDDEN)) {
			System.out.println("Okay");
			throw new ConnexionException("Login ou mot de passe incorrect");
		} else {
	        System.out.println("JWT "+jwt);
	        return AuthResponseVo.builder()
	                .token(jwt)
	                .username(user.getUsername())
	                .build();
		}
    }

}
