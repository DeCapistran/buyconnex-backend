package com.buyconnex.buyconnex.service.user;
import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.buyconnex.buyconnex.entity.security.AuthentificationResponse;
import com.buyconnex.buyconnex.entity.security.Token;
import com.buyconnex.buyconnex.entity.security.TokenType;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.repository.security.TokenRepository;
import com.buyconnex.buyconnex.repository.user.UserRepository;
import com.buyconnex.buyconnex.service.utils.JwtService;
import com.buyconnex.buyconnex.vo.AuthRequestVo;
import com.buyconnex.buyconnex.vo.UsersVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	  private final UserRepository userRepository;
	  private final TokenRepository tokenRepository;
	  private final PasswordEncoder passwordEncoder;
	  private final JwtService jwtService;
	  private final AuthenticationManager authenticationManager;

	  public AuthentificationResponse register(UsersVo request) {
	    Users user = Users.builder()
	        .dateCreation(request.getDateCreation())
	        .email(request.getEmail())
	        .firstname(request.getFirstname())
	        .lastname(request.getLastname())
	        .password(passwordEncoder.encode(request.getPassword()))
	        .roles(request.getRoles())
	        .build();
	    Users savedUser = userRepository.save(user);
	    String jwtToken = jwtService.generateToken(user);
	    String refreshToken = jwtService.generateRefreshToken(user);
	    saveUserToken(savedUser, jwtToken);
	    return AuthentificationResponse.builder()
	        .accessToken(jwtToken)
	            .refreshToken(refreshToken)
	        .build();
	  }

	  public AuthentificationResponse authenticate(AuthRequestVo request) {
	    authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(
	            request.getEmail(),
	            request.getPassword()
	        )
	    );
	    Users user = userRepository.findByEmail(request.getEmail())
	        .orElseThrow();
	    String jwtToken = jwtService.generateToken(user);
	    String refreshToken = jwtService.generateRefreshToken(user);
	    revokeAllUserTokens(user);
	    saveUserToken(user, jwtToken);
	    return AuthentificationResponse.builder()
	        .accessToken(jwtToken)
	            .refreshToken(refreshToken)
	        .build();
	  }

	  private void saveUserToken(Users users, String jwtToken) {
	    var token = Token.builder()
	        .users(users)
	        .token(jwtToken)
	        .tokenType(TokenType.BEARER)
	        .expired(false)
	        .revoked(false)
	        .build();
	    tokenRepository.save(token);
	  }

	  private void revokeAllUserTokens(Users users) {
	    var validUserTokens = tokenRepository.findAllValidTokenByUsers(users.getId());
	    if (validUserTokens.isEmpty())
	      return;
	    validUserTokens.forEach(token -> {
	      token.setExpired(true);
	      token.setRevoked(true);
	    });
	    tokenRepository.saveAll(validUserTokens);
	  }

	  public void refreshToken(
	          HttpServletRequest request,
	          HttpServletResponse response
	  ) throws IOException {
	    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
	    final String refreshToken;
	    final String userEmail;
	    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
	      return;
	    }
	    refreshToken = authHeader.substring(7);
	    userEmail = jwtService.extractUsername(refreshToken);
	    if (userEmail != null) {
	      var user = this.userRepository.findByEmail(userEmail)
	              .orElseThrow();
	      if (jwtService.isTokenValid(refreshToken, user)) {
	        var accessToken = jwtService.generateToken(user);
	        revokeAllUserTokens(user);
	        saveUserToken(user, accessToken);
	        var authResponse = AuthentificationResponse.builder()
	                .accessToken(accessToken)
	                .refreshToken(refreshToken)
	                .build();
	        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
	      }
	    }
	  }
}
