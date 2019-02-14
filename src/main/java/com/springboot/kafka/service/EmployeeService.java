package com.springboot.kafka.service;

import java.util.List;

import com.springboot.kafka.modal.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public List<Employee> getEmployee();

	public Employee findByEmpId(String empId);

	public void updateEmployeeDetails(Employee employee1);
}