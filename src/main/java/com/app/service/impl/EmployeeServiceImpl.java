package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Employee;
import com.app.repo.EmployeeRepository;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository repo;

	@Transactional
	public Integer saveEmployee(Employee e) {
		return repo.save(e).getEid();
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		List<Employee> empList=repo.findAll();
		if(empList!=null && empList.isEmpty()) {
			empList.stream()
			.sorted((e1,e2)->e1.getEname().compareTo(e2.getEname()));
		}
		return empList;
	}

	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> emp=repo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
	}

	@Transactional
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}

	@Transactional
	public Employee updateEmployee(Employee e) {
		return repo.save(e);
	}
}
