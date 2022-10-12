package com.myproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Order(1)
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final PasswordEncoder passwordEncoder;
	private final UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.headers().frameOptions().disable();
		http.csrf().disable()
			.antMatcher("/admin/***")
			.authorizeRequests()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/auth/login")
			.loginProcessingUrl("/auth/login")
			.usernameParameter("email")
			.passwordParameter("password")
			.defaultSuccessUrl("/admin/user")
			.failureUrl("/auth/login?error=true")
			.and()
			.logout()
			.logoutUrl("/auth/logout")
			.logoutSuccessUrl("/auth/login")
			.deleteCookies("JSESSIONID")
			.and()
			.exceptionHandling()
			.accessDeniedPage("/403");
	}
}