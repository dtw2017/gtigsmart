package com.gtigsmart.mis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/user").setViewName("user");
		registry.addViewController("/nav").setViewName("nav");
		registry.addViewController("/charge").setViewName("charge");
		registry.addViewController("/navmenu").setViewName("navmenu");
		registry.addViewController("/housebl").setViewName("housebl");
		registry.addViewController("/packinglist").setViewName("packinglist");
	}
}