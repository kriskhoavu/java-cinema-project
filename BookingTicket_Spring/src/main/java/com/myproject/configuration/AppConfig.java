package com.myproject.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/*")
		.allowedOrigins("*")
		.allowCredentials(false)
		.maxAge(4800)
		.allowedMethods("POST", "GET", "PUT", "DELETE");
	}

}
