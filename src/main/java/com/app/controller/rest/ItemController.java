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
import com.app.model.Item;
import com.app.service.IItemService;

@RestController
@RequestMapping("/rest/item")
public class ItemController {
	
	@Autowired
	private IItemService service;
	
	@PostMapping("/insert")
	public ResponseEntity<String> saveItem(@RequestBody Item item){
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveItem(item);
			resp=new ResponseEntity<String>("Item '"+id+"' Saved",HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllItems(){
		ResponseEntity<?> resp=null;
		try {
			List<Item> list=service.getAllItems();
			if(list!=null && !list.isEmpty())
				resp=new ResponseEntity<List<Item>>(list,HttpStatus.OK);
			else
		        resp=new ResponseEntity<String>("No Data Found", HttpStatus.OK);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneItem(@PathVariable("id")Integer id){
		ResponseEntity<?> resp=null;
		try {
			Item item=service.getOneItem(id);
			if(item!=null)
				resp=new ResponseEntity<Item>(item,HttpStatus.OK);
			else
				resp=new ResponseEntity<String>("No Data Found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable("id")Integer id){
		ResponseEntity<String> resp=null;
		try {
			service.deleteItem(id);
			resp=new ResponseEntity<String>("Customer '"+id+"' Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Id Not Found", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateItem(@RequestBody Item item) {
		ResponseEntity<?> resp=null;
		try {
			service.updateItem(item);
			resp=new ResponseEntity<String>("Customer '"+item.getItemid()+"' Updated", HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Id Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
}
