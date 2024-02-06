package com.swiggy.dao;

import java.util.List;

import com.swiggy.dto.Address;


public interface AddressDao {
	Address addAddress(Address cust);
	Address updateAddress(Address cust);
	Address removeAddress(int addId);
	Address searchAddressById(int addId);
	List<Address> allAddresses();
}
