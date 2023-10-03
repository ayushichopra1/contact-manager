package com.impressico.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impressico.entities.Address;
import com.impressico.repository.AddressRepository;
import com.impressico.services.AddressService;


@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address addAddress(Address address) {
		Address address2=this.addressRepository.save(address);
		return address2;
	}

	@Override
	public List<Address> getAllAddresses() {
		return this.addressRepository.findAll();
	}

	@Override
	public Address getAddress(Integer id) {
		return null;
	}

	@Override
	public Address updateAddress(Integer id, Address address) {
		return null;
	}

	@Override
	public void deleteAddress(Integer id) {
	}

}
