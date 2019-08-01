package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeService {
	
	public Integer saveEmployee(Employee e);
	public List<Employee> getAllEmployees();
	public Employee getOneEmployee(Integer id);
	public void deleteEmployee(Integer id);
	public Employee updateEmployee(Employee e);
	
}
