package com.java.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import com.java.dao.EmployeeDao;
import com.java.dto.EmployeeManufacture;

import com.java.model.Employee;
import com.java.services.EmployeeService;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public EmployeeManufacture getEmployee(int id) {
		Employee employee = employeeDao.getEmployee(id);
		EmployeeManufacture employeeManufacture = convert(employee);
		return employeeManufacture;
	}

	@Override
	public void updateEmployee(EmployeeManufacture employeeManufacture) {
		Employee employee = convert(employeeManufacture);
		employeeDao.updateEmployee(employee);
	}

	@Override
	public void saveEmployee(EmployeeManufacture employeeManufacture) {
		Employee employee = convert(employeeManufacture);
		employeeDao.saveEmployee(employee);
	}

	@Override
	public void deleteEmployee(EmployeeManufacture employeeManufacture) {
		Employee employee = convert(employeeManufacture);
		employeeDao.deleteEmployee(employee);
	}

	@Override
	public List<EmployeeManufacture> findAllEmployees() {
		List<EmployeeManufacture> employeeManufactures = new ArrayList<EmployeeManufacture>();
		List<Employee> employees = employeeDao.findAllEmployees();
		if (!CollectionUtils.isEmpty(employees)) {
			for (Employee employee : employees) {
				employeeManufactures.add(convert(employee));
			}
		}
		return employeeManufactures;
	}

	private Employee convert(EmployeeManufacture employeeManufacture) {
		Employee employee = new Employee();
		employee.setId(employeeManufacture.getId());
		employee.setName(employeeManufacture.getName());
		employee.setEmail(employeeManufacture.getEmail());
		employee.setDesignation(employeeManufacture.getDesignation());
		return employee;
	}

	private EmployeeManufacture convert(Employee employee) {
		EmployeeManufacture employeeManufacture = new EmployeeManufacture();

		employeeManufacture.setDesignation(employee.getDesignation());
		employeeManufacture.setEmail(employee.getEmail());
		employeeManufacture.setId(employee.getId());
		employeeManufacture.setName(employee.getName());
		return employeeManufacture;
	}

}
