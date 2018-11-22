package com.java.dao;

import java.io.Serializable;
import java.util.List;

import com.java.model.Employee;

public interface EmployeeDao {
	Employee getEmployee(int id);
	void updateEmployee(Employee employee);
	Serializable saveEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	List<Employee> findAllEmployees();
}
