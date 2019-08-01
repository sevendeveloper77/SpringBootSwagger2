package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {

	public Integer saveCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getCustomer(Integer id);
	public void deleteCustomer(Integer id);
	public Customer updateCustomer(Customer c);
}
