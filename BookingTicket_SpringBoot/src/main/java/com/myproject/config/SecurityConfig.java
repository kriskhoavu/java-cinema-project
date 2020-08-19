package com.myproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.myproject.security.JWTAuthorizationFilter;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig {
	@Autowired
    private UserDetailsService userDetailsService;

	@Autowired
	private JWTAuthorizationFilter jwtAuthorizationFilter;

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
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN")
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

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
        	return super.authenticationManagerBean();
        }
    }
}

//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.cors();
//            http.csrf().disable()
//            .authorizeRequests().antMatchers("/auth/authenticate").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//            http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
//        }