package com.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.swiggy.dao.CustomerDaoImpl;
import com.swiggy.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDaoImpl customerDao;
	
	@Override
	public ResponseEntity<Customer> addCustomer(Customer cust) {
		return customerDao.addCustomer(cust);
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		return customerDao.updateCustomer(cust);
	}

	@Override
	public Integer removeCustomer(int custId) {
		return customerDao.removeCustomer(custId);
	}

	@Override
	public Customer searchCustomerById(int custId) {
		return customerDao.searchCustomerById(custId);
	}

	@Override
	public List<Customer> allCustomers() {
		return customerDao.allCustomers();
	}

}
