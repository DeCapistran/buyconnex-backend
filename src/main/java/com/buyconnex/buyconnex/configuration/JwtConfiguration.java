package com.buyconnex.buyconnex.configuration;

import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.exception.JwtTokenMalFormedException;
import com.buyconnex.buyconnex.exception.JwtTokenMissingException;
import io.jsonwebtoken.*;

import java.util.Date;


import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtConfiguration {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(JwtConfiguration.class);

    @Value("BUY-CONNEX-BACK-END-KEY-22042024")
    private String jwtSecret;

    @Value("6480000")
    private long tokenValidity;

    public String getUserLogin(final String token) {
        try {
            Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            return body.getSubject();
        } catch (Exception e) {
            logger.error("{} => {}", e, e.getMessage());
        }
        return null;
    }

    public String generateToken(Authentication authentication) {
        final long nowTime = System.currentTimeMillis();
        Date expiration = new Date(nowTime + tokenValidity);

        Users users = (Users) authentication.getPrincipal();
        Claims claims = Jwts.claims().setSubject(users.getUserLogin());

        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowTime)).setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public void validateToken(final String token) throws JwtTokenMalFormedException {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
        } catch (SignatureException ex) {
            throw new JwtTokenMalFormedException("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            throw new JwtTokenMalFormedException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new JwtTokenMalFormedException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new JwtTokenMalFormedException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new JwtTokenMissingException("JWT claims string is empty");
        }
    }
}
