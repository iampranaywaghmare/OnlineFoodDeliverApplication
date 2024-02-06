package com.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.dto.Customer;
import com.swiggy.dto.Restaurant;
import com.swiggy.service.CustomerServiceImpl;
import com.swiggy.service.RestaurantServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerService;
	
	
	@PostMapping("/add")
	ResponseEntity<Customer> addCustomer(@RequestBody Customer cust) {
		return	customerService.addCustomer(cust);
	}
	
	@PutMapping("/update")
	Customer updateCustomer(@RequestBody Customer cust) {
		return customerService.updateCustomer(cust);
	}
	
	@DeleteMapping("/delete/{custId}")
	Integer removeCustomer(@PathVariable("custId") int custId) {
		return customerService.removeCustomer(custId);
	}
	
	@GetMapping("/find/{custId}")
	Customer searchCustomerById(@PathVariable("custId") int custId) {
		return customerService.searchCustomerById(custId);
	}
	
	@GetMapping("/all")
	List<Customer> allCustomers(){
		return customerService.allCustomers();
	}

}
