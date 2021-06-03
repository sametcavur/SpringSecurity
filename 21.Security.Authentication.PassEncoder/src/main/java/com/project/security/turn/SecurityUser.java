package com.project.security.turn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityUser extends WebSecurityConfigurerAdapter{
	
	//BU CLASSTA LOGİN'DEN GEÇEBİLECEK YETKİLİ BİR USER TANIMLADIK.
	
	//Bu bean şifreyi encrypt edip veri tabanına yollamamak için,yapmamız gereken metod alttaki metodda password içinde kullandık.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder =  PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth
			.inMemoryAuthentication()   //veritabanı yok bellekten bi doğrulama aç
			.withUser("sametcavur")		//useri bu olsun
			.password(passwordEncoder().encode("12345"))	
			.roles("USER");  			//rolüde user
	}
}
