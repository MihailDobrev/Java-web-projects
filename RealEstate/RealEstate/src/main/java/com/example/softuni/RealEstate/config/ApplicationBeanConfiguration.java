package com.example.softuni.RealEstate.config;

import javax.validation.Validation;
import javax.validation.Validator;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.softuni.RealEstate.util.HtmlReader;

@Configuration
public class ApplicationBeanConfiguration {

	@Bean
	public Validator validator()
	{
		return Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	
	@Bean
	public HtmlReader htmlReader(){
		return new HtmlReader();
	}
}
