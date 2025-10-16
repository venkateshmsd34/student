package com.rest.springboot.restapiproject.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	ModelMapper modelMapper() {
		 ModelMapper modelMapper = new ModelMapper();
	        modelMapper.getConfiguration()
	                .setSkipNullEnabled(true) // ✅ ignore null fields for PATCH
	                .setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}
}
