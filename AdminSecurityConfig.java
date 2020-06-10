// package com.myproject.config;

// import org.springframework.core.annotation.Order;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Order(1)
// @Configuration
// @EnableWebSecurity
// public class AdminSecurityConfig extends WebSecurityConfigurerAdapter{
	
// 	@Override
// 	protected void configure(HttpSecurity http) throws Exception {
// 		http.csrf().disable()
// 			.antMatcher("/admin/**")
// 				.authorizeRequests()
// 				.antMatchers("/admin/**").hasAnyRole("ADMIN")
// 				.and()
// 			.formLogin()
// 				.permitAll()
// 				.loginPage("/auth/login")
// 				.usernameParameter("email")
// 				.passwordParameter("password")
// 				.defaultSuccessUrl("/admin/user")
// 				.failureUrl("/auth/login?error=true")
// 				.and()
// 			.logout()
// 				.logoutUrl("/logout")
// 				.logoutSuccessUrl("/auth/login")
// 				.deleteCookies("JSESSIONID")
// 				.and()
// 			.exceptionHandling()
// 				.accessDeniedPage("/403");	
// 	}
// }