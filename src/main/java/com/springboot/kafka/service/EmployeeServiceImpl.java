package com.springboot.kafka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.kafka.modal.Employee;
import com.springboot.kafka.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.addEmployee(employee);

	}

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.getEmployee();
	}

	@Override
	public Employee findByEmpId(String empId) {
		Employee employee = employeeRepository.findEmployeeDetailes(empId);
		return employee;
	}

	@Override
	public void updateEmployeeDetails(Employee employee1) {
		employeeRepository.updateEmployeeValues(employee1);

	}

}
