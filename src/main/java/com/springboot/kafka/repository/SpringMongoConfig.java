package com.springboot.kafka.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig {
	
	
	
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
		
		MongoTemplate mongoTemplate = 
		    new MongoTemplate(new MongoClient("localhost", 27017),"myDb");
		return mongoTemplate;
		
	}

}
