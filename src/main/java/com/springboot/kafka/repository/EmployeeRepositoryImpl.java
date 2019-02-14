package com.springboot.kafka.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.springboot.kafka.modal.Employee;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Override
	public void addEmployee(Employee employee) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		mongoOperation.insert(employee, "employeeCollectionMongoTemplate");

	}

	@Override
	public List<Employee> getEmployee() {
		HashMap<String, Employee> hmEmployee = new HashMap<String, Employee>();

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
		List<Employee> employeeList = mongoOperation.find(new Query(), Employee.class,
				"employeeCollectionMongoTemplate");

		return employeeList;

	}

	@Override
	public Employee findEmployeeDetailes(String empId) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		Employee employee1 = mongoOperation.findOne(query(where("empId").is(empId)), Employee.class,
				"employeeCollectionMongoTemplate");
		return employee1;
	}

	@Override
	public void updateEmployeeValues(Employee employee1) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		Query query = new Query();
		query.addCriteria(new Criteria("empId").is(employee1.getEmpId()));

		Update update = new Update();
		update.set("empName", employee1.getEmpName());
		update.set("empSal", employee1.getEmpSal());
		update.set("address", employee1.getAddress());

		mongoOperation.updateFirst(query, update, Employee.class, "employeeCollectionMongoTemplate");

	}

}
