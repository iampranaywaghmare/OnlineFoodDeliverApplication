package com.swiggy.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.swiggy.dto.Customer;

public interface CustomerService {
	ResponseEntity<Customer> addCustomer(Customer cust);
	Customer updateCustomer(Customer cust);
	Integer removeCustomer(int custId);
	Customer searchCustomerById(int custId);
	List<Customer> allCustomers();
}
