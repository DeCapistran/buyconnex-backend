package com.buyconnex.buyconnex.service.user;

import com.buyconnex.buyconnex.entity.security.ResetPasswordToken;
import com.buyconnex.buyconnex.entity.security.VerificationTokenMfa;
import com.buyconnex.buyconnex.entity.user.Roles;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.repository.security.ResetPasswordTokenRepository;
import com.buyconnex.buyconnex.repository.security.VerificationTokenMfaRepository;
import com.buyconnex.buyconnex.repository.security.VerificationTokenRepository;
import com.buyconnex.buyconnex.repository.user.ContactRepository;
import com.buyconnex.buyconnex.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private ResetPasswordTokenRepository resetPasswordTokenRepository;

    private VerificationTokenMfaRepository verificationTokenMfaRepository;

    private ContactRepository contactRepository;

    @Autowired
    public UserService(@Lazy PasswordEncoder passwordEncoder, UserRepository userRepository,
                       ResetPasswordTokenRepository resetPasswordTokenRepository, VerificationTokenMfaRepository verificationTokenMfaRepository, 
                       ContactRepository contactRepository) {
        this.passwordEncoder = passwordEncoder;
    	this.userRepository = userRepository;
        this.resetPasswordTokenRepository = resetPasswordTokenRepository;
        this.verificationTokenMfaRepository = verificationTokenMfaRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUserLogin(String login) {

        Users users = userRepository.findByLogin(login).get();
        logger.info("Process Login :{}", users);
        if (!users.isBActivated() || users.isBLocked()) {
            users.setBActivated(false);
        }
        List<Roles> roles = users.getRoles().stream().collect(Collectors.toList());

        List<GrantedAuthority> grantedAuthorities = roles.stream().map(r -> {
            return new SimpleGrantedAuthority(r.getRoleName());
        }).collect(Collectors.toList());

        return new User(login, users.getPassword(), users.isBActivated(), true, true, true, grantedAuthorities);
    }

    @Override
    public Optional<Users> getUsersByUserLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Users saveUser(Users users) {
        userRepository.save(users);
        return users;
    }

    @Override
    public Optional<Users> getUsersByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public void createResetPasswordTokenForUser(Users users, String token) {
        final ResetPasswordToken myToken = new ResetPasswordToken(users, token);
        resetPasswordTokenRepository.deleteAllByUsers(users);
        resetPasswordTokenRepository.save(myToken);
    }

    @Override
    public ResetPasswordToken findUserByResetPasswordToken(String token) {
        return resetPasswordTokenRepository.findByToken(token);
    }

    @Override
    public String validatePasswordResetToken(String token) {
        final ResetPasswordToken passwordToken = resetPasswordTokenRepository.findByToken(token);
        return !isTokenFound(passwordToken) ? "InvalidToken"
                : isTokenExpired(passwordToken) ? "Expired"
                : null;
    }

    @Override
    public void changeUserPassword(ResetPasswordToken resetPasswordToken, String newPassword) {
        resetPasswordToken.getUsers().setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(resetPasswordToken.getUsers());
        if (resetPasswordToken.getId() != null) {
            resetPasswordTokenRepository.deleteById(resetPasswordToken.getId());
        }
    }

    @Override
    public VerificationTokenMfa createOtpForUser(String login, String token) {
        Optional<Users> users = userRepository.findByLogin(login);
        if (users.isPresent()) {
            verificationTokenMfaRepository.deleteAllByUsers(users.get());
            final VerificationTokenMfa tokenOtp = new VerificationTokenMfa(users.get(), token);
            verificationTokenMfaRepository.save(tokenOtp);
            return tokenOtp;
        }
        return null;
    }

    @Override
    public Optional<VerificationTokenMfa> validateOtpLogin(String otp) {
        return verificationTokenMfaRepository.findByMfaCode(otp);
    }

    @Override
    public void deleteAllOtpByUser(Users users) {
        verificationTokenMfaRepository.deleteAllByUsers(users);
    }

    @Override
    public List<Users> findUserToCreate() {
        return userRepository.findUserToCreate();
    }

    @Override
    public List<Users> findUserToUpdate() {
        return userRepository.findUserToUpdate();
    }

    private boolean isTokenFound(ResetPasswordToken passwordToken) {
        return passwordToken != null;
    }

    private boolean isTokenExpired(ResetPasswordToken passwordToken) {
        final Calendar calendar = Calendar.getInstance();
        return passwordToken.getDateExpire().before(calendar.getTime());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
