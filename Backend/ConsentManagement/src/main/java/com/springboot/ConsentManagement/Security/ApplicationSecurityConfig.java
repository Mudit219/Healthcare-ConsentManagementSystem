package com.springboot.ConsentManagement.Security;

import com.springboot.ConsentManagement.JWT.JWTTokenVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.ConsentManagement.JWT.JWTUsernameAndPasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private PasswordEncoder passEncoder;

	@Autowired
	JPAUserDetailsService jpaUserDetailsService;


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Create a JWT filter which verifies the credentials passed in by user and if it is valid, it generates a token.
		JWTUsernameAndPasswordAuthenticationFilter customJWTFilter =
				new JWTUsernameAndPasswordAuthenticationFilter(authenticationManager());

		// For every request made by the user, the token given with it is verified and then only user is authorized to execute tasks for which he is given authority.
		JWTTokenVerifier customTokenFilter = new JWTTokenVerifier();

		http
				.cors(Customizer.withDefaults())
			.csrf().disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(customJWTFilter) // Adding JWT filter so that every time user login he gets a new token.
				.addFilterAfter(customTokenFilter,JWTUsernameAndPasswordAuthenticationFilter.class) // Adding Token verifier, this will be called once after user is authorized and asking some request.
			.authorizeRequests()
				.antMatchers("/v2/api-docs/**", "/configuration/ui/**", "/swagger-resources/**", "/configuration/security/**", "/swagger-ui.html", "/webjars/**").permitAll()
				.antMatchers("/contract/**").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/admin/Valid/Doc/**").permitAll()
				.antMatchers("/admin/Valid/Pat/**").permitAll()
				.antMatchers("/admin/AddDoc").permitAll()
				.antMatchers("/admin/AddPat").permitAll()
				.antMatchers("/admin/Update-Authorities/Doc/**").permitAll()
				.antMatchers("/admin/Update-Authorities/Pat/**").permitAll()
				.antMatchers("/admin/Get-Authorities/Doc/**").permitAll()
				.antMatchers("/admin/Get-Authorities/Pat/**").permitAll()
				.antMatchers("/admin/Get-AvailableDoctors").permitAll()
				.antMatchers("/Doc/**/Profile-public").permitAll()
				.antMatchers("/Pat/**/Profile-public").permitAll()
				.anyRequest()
			.authenticated(); // For any request made by user, he/she has to be authenticated.
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
		configuration.setAllowedHeaders(List.of("*"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS"));
		configuration.setAllowCredentials(true);
		configuration.addExposedHeader("Authorization");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(){
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passEncoder); // Password encoder to decode the password.
		provider.setUserDetailsService(jpaUserDetailsService); //  Giving JPA user details service which allows connection with Database.
		return provider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
}
