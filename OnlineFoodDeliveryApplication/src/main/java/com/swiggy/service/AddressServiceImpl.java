package com.swiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.dao.AddressDaoImpl;
import com.swiggy.dto.Address;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressDaoImpl addressDao;
	
	@Override
	public Address addAddress(Address cust) {
		return addressDao.addAddress(cust);
	}

	@Override
	public Address updateAddress(Address cust) {
		return addressDao.updateAddress(cust);
	}

	@Override
	public Address removeAddress(int addId) {
		return addressDao.removeAddress(addId);
	}

	@Override
	public Address searchAddressById(int addId) {
		return addressDao.searchAddressById(addId);
	}

	@Override
	public List<Address> allCustomers() {
		return addressDao.allAddresses();
	}

	
	
}
