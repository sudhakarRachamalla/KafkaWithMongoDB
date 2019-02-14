package com.springboot.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.springboot.kafka.modal.Employee;
import com.springboot.kafka.service.EmployeeService;

public class Receiver {

	/*
	 * private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	 * 
	 * private CountDownLatch latch = new CountDownLatch(1);
	 * 
	 * public CountDownLatch getLatch() { return latch; }
	 * 
	 * @KafkaListener(topics = "${kakfa.topic.helloworld}") public void
	 * receive(Message<Employee> employee) {
	 * 
	 * Employee employee1 = employee.getMessageBody();
	 * System.out.println(employee1); LOGGER.info("received employee='{}'",
	 * employee.toString()); latch.countDown(); }
	 */

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);
	
	@Autowired
	EmployeeService employeeService;

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${kafka.topic.helloworld}")
	public void receive(Employee employee) {
		System.out.println("empId" + employee.getEmpId());
		System.out.println("empName" + employee.getEmpName());
		System.out.println("empSal" + employee.getEmpSal());
		System.out.println("empAddress" + employee.getAddress());
		
		employeeService.addEmployee(employee); 
		LOGGER.info("received car='{}'", employee.toString());
		latch.countDown();
	}
}
