package com.java.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.java.model.Employee;
import com.java.dao.AbstractDao;
import com.java.dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	@Override
	public Employee getEmployee(int id) {
		return (Employee) getSession().get(Employee.class, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	}

	@Override
	public Serializable saveEmployee(Employee employee) {
		return getSession().save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		getSession().delete(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root);
        Query<Employee> query = getSession().createQuery(criteriaQuery);
        List<Employee> employees = query.getResultList();
		return employees;
	}
}
