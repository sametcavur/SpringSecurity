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

	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("sametcavur")
			.password(passwordEncoder().encode("12345"))
			.roles("USER");
	}*/
	
	//Database bağlarken asıl olay bu metod'da dönüyor.Çünkü bu metodda kullanıcı tanımlıyoruz.
	//Normalde üstteki gibi username,password ve rol tanımlardık ama şimdi şu şekilde yapıyoruz.
	//---------------------------------------------------------------------------------------------------
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.userDetailsService(userDetailServices())
		.passwordEncoder(passwordEncoder());
	}
	
	
	@Bean
	public UserDetailServices userDetailServices() {
		return new UserDetailServices();
	}
	//----------------------------------------------------------------------------------------------------
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/login")
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/welcome")
		.and()
			.logout()
			.logoutSuccessUrl("/logout")
			.invalidateHttpSession(true)
			.permitAll();
	}
	
	@Bean	
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
