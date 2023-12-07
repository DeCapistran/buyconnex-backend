package com.buyconnex.buyconnex.service.user;

import com.buyconnex.buyconnex.entity.user.Roles;
import com.buyconnex.buyconnex.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Roles saveNewRole(Roles roles) {
        return roleRepository.save(roles);
    }
}
