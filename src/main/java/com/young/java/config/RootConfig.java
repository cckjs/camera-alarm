package com.young.java.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(value = "com.young.java", excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@EnableAspectJAutoProxy
public class RootConfig {
	@Bean
	public ObjectMapper getJsonMessageConverter() {
		MappingJackson2XmlHttpMessageConverter xmlMessageConverter = new MappingJackson2XmlHttpMessageConverter();
		// Add supported media type returned by BI API.
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(new MediaType("text", "plain"));
		supportedMediaTypes.add(new MediaType("application", "xml"));
		xmlMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		return xmlMessageConverter.getObjectMapper();
	}
}
