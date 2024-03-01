package com.buyconnex.buyconnex.repository.user;

import com.buyconnex.buyconnex.entity.user.Users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUsername(String username);
	Optional<Users> findByEmail(String email);
    
}
