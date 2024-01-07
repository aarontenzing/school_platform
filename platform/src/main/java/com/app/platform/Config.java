package com.app.platform;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationManagers;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.app.platform.handlers.LogoutHandler;
import com.app.platform.services.GebruikerService;
import com.app.platform.services.LeerkrachtService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("deprecation")
@Configuration
public class Config {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	LogoutHandler logoutHandler;
	
	@Autowired
	GebruikerService gebruikerServ;

    @Bean
    SecurityFilterChain beveilig(HttpSecurity http) throws Exception 
	{
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/leerkracht/**")
					.access(AuthorizationManagers.anyOf(
			              AuthorityAuthorizationManager.hasAuthority("ROLE_docent"),
			              AuthorityAuthorizationManager.hasAuthority("ROLE_directeur")))
				.requestMatchers("/private/**")
					.authenticated()
				.anyRequest().permitAll()
				)
				.csrf((csrf) -> csrf
						.ignoringRequestMatchers("/api/**")
				)
				.formLogin(form -> form
						.loginPage("/login")
						.permitAll()
						.successHandler(authenticationSuccessHandler())
				)
				.logout(logout -> logout
						.logoutSuccessHandler(logoutHandler)
						);
		
		return http.build();
	}

	@Bean
    PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Autowired
	public void dbauth(AuthenticationManagerBuilder auth) throws Exception {		
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT leerling_id, paswoord, enabled FROM leerlingen WHERE leerling_id=?")
		.authoritiesByUsernameQuery("SELECT leerling_id, rtrim(rol) FROM leerlingen WHERE leerling_id=?");
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("SELECT leerkracht_id, paswoord, enabled FROM leerkrachten WHERE leerkracht_id=?")
		.authoritiesByUsernameQuery("SELECT leerkracht_id, rtrim(rol) FROM leerkrachten WHERE leerkracht_id=?");		
	} 
	
	
	@Autowired
	LeerkrachtService serv;
	
	private AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {            	
            	HttpSession session = request.getSession();
            	session.setAttribute("gebruiker", gebruikerServ.getCurrentUser());
            	response.sendRedirect("/home");
			}
        };
    }
}
