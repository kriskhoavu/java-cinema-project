// package com.myproject.config;

// import com.myproject.security.JWTAuthenticationFilter;
// import com.myproject.security.JWTAuthorizationFilter;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Order(2)
// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
// 	@Autowired
// 	private UserDetailsService userDetailsService;
	
// 	@Bean
// 	public PasswordEncoder passwordEncoder() {
// 		return new BCryptPasswordEncoder();
// 	}

// 	@Override
// 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
// 		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
// 	}
	
// 	@Override
// 	protected void configure(HttpSecurity http) throws Exception {
// 		http.csrf().disable()
// 			.antMatcher("/api/**")		
// 			.authorizeRequests()	
// 			.antMatchers("/api/**").authenticated();

// 	 	http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
// 		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), userDetailsService));
// 		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
// 	}
// }