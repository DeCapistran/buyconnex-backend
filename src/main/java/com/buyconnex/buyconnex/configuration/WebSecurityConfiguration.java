package com.buyconnex.buyconnex.configuration;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

	@Autowired
	AuthenticationManager authMgr;
	
	@Autowired
	LogoutHandler logoutHandler;
	
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
	{
		http.sessionManagement( session -> 
		session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		
		.csrf( csrf -> csrf.disable()) 
		
		.cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration cors = new CorsConfiguration();
                cors.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                cors.setAllowedMethods(Collections.singletonList("*"));
                cors.setAllowedHeaders(Collections.singletonList("*"));
                cors.setExposedHeaders(Collections.singletonList("Authorization"));
                
                return cors;
            }}))
		
		.authorizeHttpRequests( requests -> requests
				.requestMatchers("/login").permitAll()
				.requestMatchers("/all").hasAuthority("ADMIN")
				.anyRequest().authenticated() )
		
		.addFilterBefore(new JwtAuthenticationFilter(authMgr), 
				UsernamePasswordAuthenticationFilter.class)
		
		.addFilterBefore(new JwtAuthorizationFilter(),
			    UsernamePasswordAuthenticationFilter.class)
		
		.logout(logout ->
        logout.logoutUrl("/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext()));
		

	return http.build();
	}
	
    
}
