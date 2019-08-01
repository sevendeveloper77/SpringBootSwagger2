package com.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/rest/customer")
public class CustomerController {
	@Autowired
	private ICustomerService service;
	
	@PostMapping("/insert")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveCustomer(customer);
			resp=new ResponseEntity<String>("Customer '"+id+"' Saved",HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getCustomers(){
		ResponseEntity<?> resp=null;
		try {
			List<Customer> list=service.getAllCustomers();
			if(list!=null && !list.isEmpty())
				resp=new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
			else
		        resp=new ResponseEntity<String>("No Data Found", HttpStatus.OK);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneCustomer(@PathVariable("id")Integer cid){
		ResponseEntity<?> resp=null;
		try {
			Customer cust=service.getCustomer(cid);
			if(cust!=null)
				resp=new ResponseEntity<Customer>(cust,HttpStatus.OK);
			else
				resp=new ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id")Integer cid){
		ResponseEntity<String> resp=null;
		try {
			service.deleteCustomer(cid);
			resp=new ResponseEntity<String>("Customer '"+cid+"' Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Id Not Found", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		ResponseEntity<?> resp=null;
		try {
			service.updateCustomer(customer);
			resp=new ResponseEntity<String>("Customer '"+customer.getCid()+"' Updated", HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Id Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
}
