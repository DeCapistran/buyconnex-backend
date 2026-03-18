package com.buyconnex.buyconnex.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buyconnex.buyconnex.entity.security.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	VerificationToken findByToken(String token);
}
