package com.challenge.ecommerce.tps.product_management.config.infrastructure;

import com.challenge.ecommerce.tps.encript.KeyRsaSupplier;
import com.challenge.ecommerce.tps.filter.AuthenticationFilter;
import com.challenge.ecommerce.tps.jwt.JwtManagement;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

	@Value("${settings-jks.path}")
	private String pathJks;

	@Value("${settings-jks.password}")
	private String passwordJks;

	@Value("${settings-jks.alias}")
	private String aliasJks;

	@Value("${settings-refresh-token.times.jwt}")
	private Long expiryTimeAtMinutes;

	@Bean
	public KeyRsaSupplier keyRsaSupplier()
			throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
		return new KeyRsaSupplier(this.passwordJks, this.aliasJks, this.pathJks);
	}

	@Primary
	@Bean
	public JwtManagement jwtManagement(final KeyRsaSupplier keyRsaSupplier) {
		return new JwtManagement(keyRsaSupplier, this.expiryTimeAtMinutes);
	}

	@Bean
	public AuthenticationFilter authenticationFilter(final JwtManagement jwtManagement) {
		return AuthenticationFilter.builder().jwtManagement(jwtManagement).excludeUrlPatterns(List.of()).build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedOriginPattern("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http, final AuthenticationFilter authenticationFilter)
			throws Exception {
		http.csrf(AbstractHttpConfigurer::disable).cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.authorizeHttpRequests(authRequest -> authRequest.anyRequest().authenticated())
				.sessionManagement(
						sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return username -> null;
	}
}
