package com.codingdojo.waterbnb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	private UserDetailsService userDetailsService;
	public WebSecurityConfig(UserDetailsService userDetailsService) {
	    this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.
	        authorizeRequests()
	            .antMatchers("/static/**", "/registlogin", "/home", "/search", "/listings/view/**").permitAll()
	            .antMatchers("/listings/addreview/**").access("hasRole('ROLE_GUEST')")
	            .antMatchers("/host/**", "/listings/addreview/**").access("hasRole('ROLE_HOST')") //authorization with only host role can access
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/login")
	            .permitAll()
	            .and()
	        .logout()
	            .permitAll();
	    //ADD THIS CODE TO DISABLE CSRF IN PROJECT. CSRF enabled issue that doesn't allow POST requests
	    http.csrf().disable();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}
