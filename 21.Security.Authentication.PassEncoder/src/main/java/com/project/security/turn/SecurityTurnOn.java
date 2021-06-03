package com.project.security.turn;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//@EnableWebSecurity
public class SecurityTurnOn extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated() 
		.and() 
			.formLogin()
		.and()
			.httpBasic();
	}
}
