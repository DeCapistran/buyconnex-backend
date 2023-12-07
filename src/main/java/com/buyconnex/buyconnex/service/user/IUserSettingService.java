package com.buyconnex.buyconnex.service.user;

import com.buyconnex.buyconnex.entity.user.Users;

public interface IUserSettingService {

    public Users loadUserByLogin(String login);
}
