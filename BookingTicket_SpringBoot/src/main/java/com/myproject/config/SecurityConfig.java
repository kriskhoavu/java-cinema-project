package com.myproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Order(1)
    @Configuration
    public class AdminConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
            .authorizeRequests().antMatchers("/authenticate").permitAll()
            .anyRequest().authenticated();
        }

       /*  @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
            .requestMatchers().antMatchers("/admin/**")
            .and()
            .authorizeRequests().anyRequest().hasRole("ADMIN")
            .and()
            .httpBasic(); 
    	http.csrf().disable()
			.antMatcher("/admin/**")
				.authorizeRequests()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.and()
			.formLogin()
				.permitAll()
				.loginPage("/auth/login")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/admin/user")
				.failureUrl("/auth/login?error=true")
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/auth/login")
				.deleteCookies("JSESSIONID")
				.and()
			.exceptionHandling()
				.accessDeniedPage("/403");	           
        } */
    }
}