package com.AmaliaStefan;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "amalia";
		String encodePassword = encoder.encode(rawPassword);
		
		System.out.println(encodePassword);


	}

}
