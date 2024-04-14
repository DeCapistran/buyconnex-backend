package com.buyconnex.buyconnex.service.user;

import java.util.Optional;

import com.buyconnex.buyconnex.entity.security.VerificationToken;
import com.buyconnex.buyconnex.entity.user.Roles;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.exception.ExpiredTokenException;
import com.buyconnex.buyconnex.vo.NewPasswordVo;
import com.buyconnex.buyconnex.vo.RegistrationRequestVo;

public interface IUserService {

	Users saveUser(Users user);
	Users findUserByUsername (String username);
	Roles addRole(Roles role);
	Users addRoleToUser(String username, String rolename);
	Users registerUser(RegistrationRequestVo request);
	public void updatePassword(Users user, NewPasswordVo newPassword);
	public void sendEmailUser(Users users, String code);
	public Users validateToken(String code) throws ExpiredTokenException;
	VerificationToken findUserByTokenVerificationToken(String token);
	Optional<Users> findUserByEmail(String email);
}
