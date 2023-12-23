package com.app.platform.controllers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public SecurityFilterChain beveilig(HttpSecurity http) throws Exception 
	{
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/private/**").authenticated()
				.anyRequest().permitAll()
				)
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/home")
						.permitAll()
				)
				.logout(logout -> logout
						.logoutSuccessUrl("/login"));
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void dbauth(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username,passwd,1 from users where username = ?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username = ?");
	}

}
