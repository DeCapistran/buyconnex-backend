package com.buyconnex.buyconnex.repository.security;

import com.buyconnex.buyconnex.entity.security.VerificationTokenMfa;
import com.buyconnex.buyconnex.entity.user.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface VerificationTokenMfaRepository extends JpaRepository<VerificationTokenMfa, Long> {

    public Optional<VerificationTokenMfa> findByCodeMfa(String otp);

    public Optional<VerificationTokenMfa> findByUser(Users users);

    @Transactional
    public void deleteAllByUser(Users users);

    @Modifying
    @Query("delete from VerificationTokenMfa v where v.dateExpire <= ?1")
    void deleteAllExpiredSince(Date now);
}
