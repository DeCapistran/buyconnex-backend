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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;


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
                cors.setAllowedOrigins(Collections.singletonList("*"));
                cors.setAllowedMethods(Collections.singletonList("*"));
                cors.setAllowCredentials(false);
                cors.setAllowedHeaders(Collections.singletonList("*"));
                cors.setExposedHeaders(Collections.singletonList("Authorization"));
                cors.setMaxAge(3600L);
                return cors;
            }}))
		
		.addFilterBefore(new JwtAuthenticationFilter(authMgr), 
				UsernamePasswordAuthenticationFilter.class)
		
		.addFilterBefore(new JwtAuthorizationFilter(),
			    UsernamePasswordAuthenticationFilter.class)
		
		.authorizeHttpRequests( requests -> requests
				.requestMatchers("/login",
						"/register/**",
						"/verifyEmail/**",
						"/update-password/**",
						"/all-users",
						"/api/articles/**",
						"/api/avis/**",
						"/api/boutiques/**",
						"/api/images/**",
						"/api/marques/**",
						"/api/sous-categories/**",
						"/api/status-articles/**",
						"/api/tags/**",
						"/api/articles-images/**",
						"/api/tags-articles/**",
						"/api/adresses/**",
						"/api/clients/**",
						"/api/communes/**",
						"/api/paniers-details/**",
						"/api/paniers/**",
						"/api/pays/**",
						"/api/villes/**",
						"/api/newsletters/**",
						"/api/footers/**",
						"/api/sliders/**",
						"/api/commandes-details/**",
						"/api/commandes/**",
						"/api/coupons/**",
						"/api/expeditions/**",
						"/api/facturations/**",
						"/api/livraisons-details/**",
						"/api/livraisons/**",
						"/api/moyens-livraisons/**",
						"/api/moyens-paiements/**",
						"/api/paiements/**",
						"/api/promotions-details/**",
						"/api/promotions/**",
						"/api/status-commandes/**",
						"/api/status-livraisons/**",
						"/api/status-paiements/**"
						).permitAll()
				.requestMatchers("/all").hasAuthority("ADMIN")
				.anyRequest().authenticated())
		
		.logout(logout ->
        logout.logoutUrl("/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext()));
		

	return http.build();
	}
	
    
}
