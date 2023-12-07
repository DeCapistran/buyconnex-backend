package com.buyconnex.buyconnex.repository.order;

import com.buyconnex.buyconnex.entity.user.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, String> {

}
