package com.ofss;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// This method is used to provide the username & password in memory
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("oracle").password("{noop}oracle123").roles("USERS");
			// noop means no encoder is used for password
			// avoided in the production environment
		}

		// This method is to define which APIs must be secured, currently I have given all APIs
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
		}


}

