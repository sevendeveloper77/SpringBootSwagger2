package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Customer;
import com.app.repo.CustomerRepository;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

		@Autowired
		private CustomerRepository repo;

		@Transactional
		public Integer saveCustomer(Customer c) {
			return repo.save(c).getCid();
		}

		@Transactional(readOnly = true)
		public List<Customer> getAllCustomers() {
			 List<Customer> custList=repo.findAll();
			 if(custList!=null && !custList.isEmpty()) {
				 custList.stream()
				 .sorted((c1,c2)->c1.getCname().compareTo(c2.getCname()));
			 }			 
			 return custList;
		}

		@Transactional(readOnly = true)
		public Customer getCustomer(Integer id) {
			Optional<Customer> cust=repo.findById(id);
			if(cust.isPresent()) {
				return cust.get();
			}
			
			return null;
		}

		@Transactional
		public void deleteCustomer(Integer id) {
			repo.deleteById(id);
		}

		@Transactional
		public Customer updateCustomer(Customer c) {
			return repo.save(c);
		}
		
		
}
