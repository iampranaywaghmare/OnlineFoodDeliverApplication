package com.swiggy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.swiggy.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("select c from Customer c where c.customerId= :custId")
	Customer searchCustomer(@Param("custId") int custId);
	
	
	
	@Transactional
	@Modifying
	@Query("delete from Customer c where c.customerId =:custId")
	public Integer removeCustomer(@Param("custId")  int custId);
}
