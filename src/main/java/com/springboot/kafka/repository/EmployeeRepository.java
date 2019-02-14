package com.springboot.kafka.repository;

import java.util.List;

import com.springboot.kafka.modal.Employee;

public interface EmployeeRepository {

	public void addEmployee(Employee employee);

	public List<Employee> getEmployee();

	public Employee findEmployeeDetailes(String empId);

	public void updateEmployeeValues(Employee employee1);

}
