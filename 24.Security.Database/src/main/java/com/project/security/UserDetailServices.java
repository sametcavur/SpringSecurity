package com.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDetailServices implements UserDetailsService {

	/*
	 * Bu implements ettiğimiz interface security kütüphanesine ait
	 *
	 * Bütün olay bu classta dönüyor.Eğer veritabanından kayıt almak istiyor ve ona yetki 
	 * vermek istiyorsak userRepositoryImpl adında classımız olacaktı
	 * işte o classı şu şekilde import edecektik.
	 *	
	 *		@Autowired
	 *		private userRepositoryImpl userRepository;
	 *
	 *	Daha sonra aşağıdaki metodun içinde User user = userRepository.findByUsername ile arayıp getirecektik.
	 *	username zaten parametrede verildi.
	 *	Daha sonra  String password = user.getPassword() ve String roles = user.getRoles()
	 *	şeklinde bu userin şifresini ve rolünü alacaktık.En son bu metodun sonundaki gibi build edecektik.
	 *
	*/
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password = "12345";
		String roles = "USER";
		return User
				.withUsername(username)
				.password(passwordEncoder.encode(password))
				.roles(roles)
				.build();
	}
}