package com.springboot.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.springboot.kafka.modal.Employee;

public class Sender {

	/*
	 * private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	 * 
	 * @Autowired private KafkaTemplate<String, String> kafkaTemplate;
	 * 
	 * public void send(String topic, String payload) {
	 * LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
	 * kafkaTemplate.send(topic, payload); }
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Value("${kafka.topic.helloworld}")
	private String jsonTopic;

	@Autowired
	private KafkaTemplate<String, Employee> kafkaTemplate;

	public void send(Employee employee) {
		LOGGER.info("sending car='{}'", employee.toString());
		kafkaTemplate.send(jsonTopic, employee);
	}
}
