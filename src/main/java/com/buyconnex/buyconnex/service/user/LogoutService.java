package com.buyconnex.buyconnex.service.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import com.buyconnex.buyconnex.repository.security.VerificationTokenRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {
	
	 private final VerificationTokenRepository tokenRepository;

	  @Override
	  public void logout(
	      HttpServletRequest request,
	      HttpServletResponse response,
	      Authentication authentication
	  ) {
	    final String authHeader = request.getHeader("Authorization");
	    final String jwt;
	    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
	      return;
	    }
	    jwt = authHeader.substring(7);
	    var storedToken = tokenRepository.findByToken(jwt)
	        .orElse(null);
	    if (storedToken != null) {
	      SecurityContextHolder.clearContext();
	    }
	  }

}
