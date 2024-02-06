package com.swiggy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.swiggy.dto.Customer;
import com.swiggy.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public ResponseEntity<Customer> addCustomer(Customer cust) {
		customerRepo.save(cust);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		return customerRepo.save(cust);
	}

	@Override
	public Integer removeCustomer(int custId) {
		return customerRepo.removeCustomer(custId);
	}

	@Override
	public Customer searchCustomerById(int custId) {
		return customerRepo.searchCustomer(custId);
	}

	@Override
	public List<Customer> allCustomers() {
		return customerRepo.findAll();
	}

}
