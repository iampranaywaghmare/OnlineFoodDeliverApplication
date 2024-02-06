package com.swiggy.service;

import java.util.List;

import com.swiggy.dto.Address;

public interface AddressService {
	Address addAddress(Address cust);
	Address updateAddress(Address cust);
	Address removeAddress(int addId);
	Address searchAddressById(int addId);
	List<Address> allCustomers();
}
