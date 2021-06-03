package com.project.security.turn;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityTurnOn extends WebSecurityConfigurerAdapter {

	// Security'de bir tane turn off bir tane turn on classı var
	// eğer security çalıştırıcaksak turn on classının üstündeki anotasyonu
	// kullanıcaz dolayısıyla turn off classındakini slaş slaş ile açıklama haline
	// getiricez. eğer security çalıştırtırmayacaksak turn off classının üstündeki
	// anotasyonu kullanıcaz dolayısıyla turn on classındakini slaş slaş ile
	// açıklama haline getiricez.

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// burada türkçe konuşur gibi http adlı propertiemize neleri nasıl işlemden geçireceğini anlatıcaz
		http// bu alttaki 3 özellikte httpye gelen bütün requestleri authorize et demek
			.authorizeRequests()
			.anyRequest()
			.authenticated() 
		.and() // and demek buraya kadar olanlar http propuna ait 1 özellik,ve bu and'dan sonra tekrar başa dönüp http. diyip devam eder gibi diğer özellikler
			.formLogin()
		.and()
			.httpBasic();//bununla direk login sayfasına gitmiyoruz da yukarıdan google login gibi açılıyor.özel bi front kodu
		
		//Bu yukarıdaki kodların tümü zaten default olarak gelenler 
		//super.configure(http); yukarıdaki kod ile aynı anlamı taşıyor.
	}
}
