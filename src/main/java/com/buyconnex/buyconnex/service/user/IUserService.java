package com.buyconnex.buyconnex.service.user;

import com.buyconnex.buyconnex.entity.security.ResetPasswordToken;
import com.buyconnex.buyconnex.entity.security.VerificationTokenMfa;
import com.buyconnex.buyconnex.entity.user.Users;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {

    public UserDetails loadUserByUserLogin(String userLogin) throws UsernameNotFoundException;

    public Optional<Users> getUsersByUserLogin(String userLogin);

    public Users saveUser(Users users);

    public Optional<Users> getUsersByEmail(String email);

    public void createResetPasswordTokenForUser(Users users, String token);

    public ResetPasswordToken findUserByResetPasswordToken(String token);

    public String validatePasswordResetToken(String token);

    public void changeUserPassword(ResetPasswordToken resetPasswordToken, String newPassword);

    public VerificationTokenMfa createOtpForUser(String login, String token);

    public Optional<VerificationTokenMfa> validateOtpLogin(String otp);

    public void deleteAllOtpByUser(Users users);

    public List<Users> findUserToCreate();

    public List<Users> findUserToUpdate();

}
