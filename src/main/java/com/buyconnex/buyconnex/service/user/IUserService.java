package com.buyconnex.buyconnex.service.user;

import java.util.Optional;

import com.buyconnex.buyconnex.entity.security.VerificationToken;
import com.buyconnex.buyconnex.entity.user.Roles;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.exception.ExpiredTokenException;
import com.buyconnex.buyconnex.vo.NewPasswordVo;
import com.buyconnex.buyconnex.vo.RegistrationRequestVo;

public interface IUserService {

	public Users saveUser(Users user);
	public Users findUserByUsername (String username);
	public Roles addRole(Roles role);
	public Users addRoleToUser(String username, String rolename);
	public Users registerUser(RegistrationRequestVo request);
	public void updatePassword(Users user, NewPasswordVo newPassword);
	public void sendEmailUser(Users users, String code);
	public Users validateToken(String code) throws ExpiredTokenException;
	public VerificationToken findUserByTokenVerificationToken(String token);
	public Optional<Users> findUserByEmail(String email);
}
