package com.project.security.turn;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityTurnOff extends WebSecurityConfigurerAdapter {

	// Security'de bir tane turn off bir tane turn on classı var
	// eğer security çalıştırıcaksak turn on classının üstündeki anotasyonu
	// kullanıcaz dolayısıyla turn off classındakini slaş slaş ile açıklama haline
	// getiricez. eğer security çalıştırtırmayacaksak turn off classının üstündeki
	// anotasyonu kullanıcaz dolayısıyla turn on classındakini slaş slaş ile
	// açıklama haline getiricez.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	}
}
