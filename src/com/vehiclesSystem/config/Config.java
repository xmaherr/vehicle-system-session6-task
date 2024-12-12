package com.vehiclesSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.vehiclesSystem")
@PropertySource("classpath:com/vehiclesSystem/application.properties")
public class Config {

}
