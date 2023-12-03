package com.buyconnex.buyconnex.service;

import com.buyconnex.buyconnex.dao.RolesDao;
import com.buyconnex.buyconnex.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private RolesDao rolesDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


}
