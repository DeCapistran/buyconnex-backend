package com.buyconnex.buyconnex.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.user.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {

	Roles findByRole(String role);
}
