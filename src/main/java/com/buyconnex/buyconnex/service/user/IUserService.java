package com.buyconnex.buyconnex.service.user;

import com.buyconnex.buyconnex.entity.user.Users;

public interface IUserService {

    public Users saveNewUser(Users users);
    public String loadUserByUsername(String username);
}
