package com.swiggy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.swiggy.dto.Address;
import com.swiggy.repository.AddressRepository;

@Repository
public class AddressDaoImpl implements AddressDao{

	@Autowired
	AddressRepository addressRepo;
	
	@Override
	public Address addAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		return addressRepo.save(address);
	}

	@Override
	public Address removeAddress(int addId){
		 Address address = addressRepo.findById(addId).orElse(null);
		 if(address != null) {
			 addressRepo.deleteById(addId);
		 }
		 return address;
	}

	@Override
	public Address searchAddressById(int addId) {
		return addressRepo.findById(addId).orElse(null);
	}

	@Override
	public List<Address> allAddresses() {
		return addressRepo.findAll();
	}

}
