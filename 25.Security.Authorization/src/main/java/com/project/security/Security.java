package com.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/low").hasAnyRole("USER","ADMIN")
		.antMatchers("/high").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
			.and()
		.formLogin()
		.defaultSuccessUrl("/welcome")
		.permitAll()
			.and()
		.logout()
		.logoutSuccessUrl("/login")
		.invalidateHttpSession(true)
		.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		builder
			.inMemoryAuthentication()
				.withUser("sametcavur")
				.password(passwordEncoder().encode("123456"))
				.roles("USER","ADMIN")
					.and()
				.withUser("metin")
				.password(passwordEncoder().encode("112233"))
				.roles("USER")	;
	}
}