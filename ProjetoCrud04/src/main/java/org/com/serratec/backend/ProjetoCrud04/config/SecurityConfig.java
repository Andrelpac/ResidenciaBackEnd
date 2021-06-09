package org.com.serratec.backend.ProjetoCrud04.config;

import org.com.serratec.backend.ProjetoCrud04.security.AuthService;
import org.com.serratec.backend.ProjetoCrud04.security.JWTAutheticationFilter;
import org.com.serratec.backend.ProjetoCrud04.security.JWTAuthorizationFilter;
import org.com.serratec.backend.ProjetoCrud04.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	AuthService service;
	
	private static final String[] AUTH_WHITELIST = {
			"/autor",
	};

	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.addFilterBefore(new JWTAutheticationFilter(authenticationManager(), jwtUtil),
                UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(new JWTAuthorizationFilter(),
                UsernamePasswordAuthenticationFilter.class);
		http.authorizeRequests()
		.antMatchers(AUTH_WHITELIST).permitAll()
		.anyRequest().authenticated();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(service).passwordEncoder(bCryptPasswordEncoder());
	}
	
}
