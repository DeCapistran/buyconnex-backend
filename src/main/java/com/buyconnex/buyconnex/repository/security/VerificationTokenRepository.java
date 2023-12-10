package com.buyconnex.buyconnex.repository.security;

import com.buyconnex.buyconnex.entity.security.ResetPasswordToken;
import com.buyconnex.buyconnex.entity.security.VerificationToken;
import com.buyconnex.buyconnex.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.stream.Stream;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(Users users);

    Stream<ResetPasswordToken> findAllByDateExpireLessThan(Date now);

    @Modifying
    @Query("delete from VerificationToken v where v.dateExpire <= ?1")
    void deleteAllExpiredSince(Date now);
}
