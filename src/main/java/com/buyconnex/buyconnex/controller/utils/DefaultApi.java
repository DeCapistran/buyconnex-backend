package com.buyconnex.buyconnex.controller.utils;

import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.security.Principal;
import java.util.Optional;

public class DefaultApi {

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    protected IUserService userService;

    protected Optional<Users> getUser(Principal principal) {
        return userService.getUsersByEmail(principal.getName());
    }
}
