package com.buyconnex.buyconnex.dao;

import com.buyconnex.buyconnex.entity.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDao extends CrudRepository<Roles, String> {
}
