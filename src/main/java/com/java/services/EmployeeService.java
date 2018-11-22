package com.java.services;

import java.util.List;

import com.java.dto.EmployeeManufacture;

public interface EmployeeService {
	EmployeeManufacture getEmployee(int id);
	void updateEmployee(EmployeeManufacture employee);
	void saveEmployee(EmployeeManufacture employee);
	void deleteEmployee(EmployeeManufacture employee);
	List<EmployeeManufacture> findAllEmployees();
}
