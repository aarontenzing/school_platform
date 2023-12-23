package com.app.platform.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {
	
	@Bean
	public SecurityFilterChain beveilig(HttpSecurity http) throws Exception 
	{
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/home").permitAll()
				.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.defaultSuccessUrl("/home.html")
			    );
		
		return http.build();
	}

}
