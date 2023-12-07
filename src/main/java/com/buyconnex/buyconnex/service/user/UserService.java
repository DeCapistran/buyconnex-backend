package com.buyconnex.buyconnex.service.user;

import com.buyconnex.buyconnex.entity.user.Roles;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.repository.user.RoleRepository;
import com.buyconnex.buyconnex.repository.order.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users saveNewUser(Users users) {
        Roles role = roleRepository.findById("Users").get();
        Set<Roles> userRoles = new HashSet<>();
        userRoles.add(role);
        users.setRoles(userRoles);
        users.setUserPassword(getEncodedPassword(users.getUserPassword()));

        return userRepository.save(users);
    }

    public String loadUserByUsername(String username) {
        return username;
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
