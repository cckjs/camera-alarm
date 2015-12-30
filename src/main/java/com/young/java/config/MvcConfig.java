package com.young.java.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.young.java.controller")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public PageableHandlerMethodArgumentResolver pageableHandlerResolver() {
		return new PageableHandlerMethodArgumentResolver();
	}

	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {

		// Extra argument resolvers (the default ones are added as well).
		argumentResolvers.add(pageableHandlerResolver());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

}
