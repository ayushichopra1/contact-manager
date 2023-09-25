package com.impressico.services;

import java.util.List;

import com.impressico.entities.Address;

public interface AddressService {

	Address addAddress(Address address);

	List<Address> getAllAddresses();

	Address getAddress(Integer id);

	Address updateAddress(Integer id, Address address);

	void deleteAddress(Integer id);
}
