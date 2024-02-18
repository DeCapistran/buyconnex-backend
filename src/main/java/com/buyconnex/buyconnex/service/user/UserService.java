package com.buyconnex.buyconnex.service.user;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.repository.user.UserRepository;
import com.buyconnex.buyconnex.vo.NewPasswordVo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

	private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    
    public void changePassword(NewPasswordVo request, Principal connectedUser) {

        Users user =  (Users) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new IllegalStateException("Mauvais Mot de Passe");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new IllegalStateException("Mot de Passe non Identique");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }
}
