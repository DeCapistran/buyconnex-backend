package com.buyconnex.buyconnex.repository.security;

import com.buyconnex.buyconnex.entity.security.ResetPasswordToken;
import com.buyconnex.buyconnex.entity.user.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.stream.Stream;

@Repository
public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Long> {

    ResetPasswordToken findByToken(String token);

    ResetPasswordToken findByUsers(Users users);

    Stream<ResetPasswordToken> findAllByDateExpireLessThan(Date now);

    @Modifying
    @Query("delete from ResetPasswordToken r where r.dateExpire <= ?1")
    void deleteAllExpiredSince(Date now);
    
    @Override
    void deleteById(Long id);

    @Transactional
    void deleteAllByUsers(Users users);

}
