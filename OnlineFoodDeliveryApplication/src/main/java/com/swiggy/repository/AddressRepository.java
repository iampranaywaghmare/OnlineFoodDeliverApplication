package com.swiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swiggy.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
