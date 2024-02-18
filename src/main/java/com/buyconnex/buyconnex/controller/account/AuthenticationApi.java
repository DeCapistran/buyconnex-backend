package com.buyconnex.buyconnex.controller.account;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.entity.security.AuthentificationResponse;
import com.buyconnex.buyconnex.service.user.AuthenticationService;
import com.buyconnex.buyconnex.vo.AuthRequestVo;
import com.buyconnex.buyconnex.vo.UsersVo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

	private final AuthenticationService service;

	  @PostMapping("/register")
	  public ResponseEntity<AuthentificationResponse> register(
	      @RequestBody UsersVo request
	  ) {
	    return ResponseEntity.ok(service.register(request));
	  }
	  @PostMapping("/authenticate")
	  public ResponseEntity<AuthentificationResponse> authenticate(
	      @RequestBody AuthRequestVo request
	  ) {
	    return ResponseEntity.ok(service.authenticate(request));
	  }

	  @PostMapping("/refresh-token")
	  public void refreshToken(
	      HttpServletRequest request,
	      HttpServletResponse response
	  ) throws IOException {
	    service.refreshToken(request, response);
	  }
}
