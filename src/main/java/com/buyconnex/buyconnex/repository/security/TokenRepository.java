package com.buyconnex.buyconnex.repository.security;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.buyconnex.buyconnex.entity.security.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{

	@Query("select t from Token t inner join Users u "+
		      "on t.users.id = u.id "+
		      "where u.id = :id and (t.expired = false or t.revoked = false)")
    List<Token> findAllValidTokenByUsers(Long id);

    Optional<Token> findByToken(String token);
}
