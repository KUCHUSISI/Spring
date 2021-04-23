package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.example")
@EnableMongoRepositories("com.example.repository")
public class SpringGradleApplication extends WebMvcConfigurationSupport
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringGradleApplication.class, args);
	}
}
