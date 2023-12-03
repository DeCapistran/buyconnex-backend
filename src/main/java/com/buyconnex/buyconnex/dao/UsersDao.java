package com.buyconnex.buyconnex.dao;

import com.buyconnex.buyconnex.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends CrudRepository<Users, String> {

}
