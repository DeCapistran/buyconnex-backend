package com.buyconnex.buyconnex.batch;

import com.buyconnex.buyconnex.entity.security.VerificationToken;
import com.buyconnex.buyconnex.repository.security.ResetPasswordTokenRepository;
import com.buyconnex.buyconnex.repository.security.VerificationTokenMfaRepository;
import com.buyconnex.buyconnex.repository.security.VerificationTokenRepository;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class TokenPurgeBatch {
    @NonNull
    private VerificationTokenRepository tokenRepository;

    @NonNull
    private ResetPasswordTokenRepository resetPasswordTokenRepository;

    @NonNull
    private VerificationTokenMfaRepository verificationTokenMfaRepository;

    @Scheduled(cron = "${purge.cron.expression}")
    public void purgeExpired() {
        Date now = Date.from(Instant.now());
        resetPasswordTokenRepository.deleteAllExpiredSince(now);
        tokenRepository.deleteAllExpiredSince(now);
        verificationTokenMfaRepository.deleteAllExpiredSince(now);
    }
}
