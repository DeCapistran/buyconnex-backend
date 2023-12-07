package com.buyconnex.buyconnex.repository.user;

import com.buyconnex.buyconnex.entity.user.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Roles, String> {

}
