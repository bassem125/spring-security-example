package com.bassem.boot1.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = encoder();

		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as cridentials, active from user where username=?")
			.authoritiesByUsernameQuery("select user_username as principal, roles_role as role from user_roles where user_username=?")
			.passwordEncoder(encoder)
			.rolePrefix("ROLE_");
			
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").defaultSuccessUrl("/home")
						.failureUrl("/login?error").permitAll();						
		http.authorizeRequests().antMatchers("/add**/**", "/del**/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/bootstrap/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.exceptionHandling().accessDeniedPage("/access-denied");
		http.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder encoder() {
			return new BCryptPasswordEncoder();
	}
}
