package com.buyconnex.buyconnex.filter;

import com.buyconnex.buyconnex.configuration.JwtConfiguration;
import com.buyconnex.buyconnex.exception.JwtTokenMalFormedException;
import com.buyconnex.buyconnex.exception.JwtTokenMissingException;
import com.buyconnex.buyconnex.service.user.IUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthentificationFilter extends OncePerRequestFilter {

    @NonNull
    private JwtConfiguration jwtUtilConfiguration;

    @NonNull
    private IUserService userAuthService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.contains("HTTP_BUYCONNEX_TOKEN")) {
            throw new JwtTokenMissingException("No JWT token found in the request headers");
        }

        int index = header.contains("Bearer") ? "bearer HTTP_BUYCONNEX_TOKEN".length() : "HTTP_BUYCONNEX_TOKEN".length();
        String token = header.substring(index + 1);

        try {
            jwtUtilConfiguration.validateToken(token);
        } catch (JwtTokenMalFormedException e) {
            throw new RuntimeException(e);
        }

        String login = jwtUtilConfiguration.getUserLogin(token);

        UserDetails userDetails = userAuthService.loadUserByUserLogin(login);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());

        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        filterChain.doFilter(request, response);

    }
}
