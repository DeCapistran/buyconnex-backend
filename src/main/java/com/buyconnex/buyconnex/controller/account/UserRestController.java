package com.buyconnex.buyconnex.controller.account;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buyconnex.buyconnex.entity.security.VerificationToken;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.exception.ExpiredTokenException;
import com.buyconnex.buyconnex.repository.user.UserRepository;
import com.buyconnex.buyconnex.service.user.AuthenticationService;
import com.buyconnex.buyconnex.service.user.UserService;
import com.buyconnex.buyconnex.vo.AuthRequestVo;
import com.buyconnex.buyconnex.vo.AuthResponseVo;
import com.buyconnex.buyconnex.vo.NewPasswordVo;
import com.buyconnex.buyconnex.vo.RegistrationRequestVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	UserRepository userRep;

	@Autowired
	UserService userService;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<AuthResponseVo> login(@RequestBody AuthRequestVo request) {
		return ResponseEntity.ok(authenticationService.authenticate(request));
	}

	@GetMapping("/all-users")
	public List<Users> getAllUsers() {
		return userRep.findAll();
	}

	@PostMapping("/register")
	public Users register(@RequestBody RegistrationRequestVo request) {
		return userService.registerUser(request);

	}
	
	@PostMapping("/update-password")
	public void updatePassword(@RequestBody NewPasswordVo newPasswordVo) {
		//newPasswordVo.setToken("321644");
		Users user = userService.findUserByUsername(newPasswordVo.getLogin());
			userService.updatePassword(user, newPasswordVo);	
	}

	@GetMapping("/verifyEmail/{token}")
	public Users verifyEmail(@PathVariable("token") String token) throws ExpiredTokenException {
		return userService.validateToken(token);
	}
}
