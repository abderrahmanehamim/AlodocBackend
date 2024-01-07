package com.Stage.AloDoctor;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfiguration implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/api/**")
	            .allowedOrigins("http://localhost:4200")
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	            .allowCredentials(true)
	            .allowedHeaders("*")
	            .exposedHeaders("Authorization");
	}
}