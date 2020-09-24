package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class DemoAppSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
			.withUser("person")
			.password(passwordEncoder.encode("password"))
			.roles("USER")
			.and()
			.withUser("admin")
			.password(passwordEncoder.encode("admin"))
			.roles("Admin");
			
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests().
			antMatchers("/login").hasAnyRole("Admin", "USER")
			.and().formLogin();
		
	}
	
	
	@Bean
	public PasswordEncoder passwordManager() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityContext securityContext() {
		return  SecurityContextHolder.getContext();
	}

}
