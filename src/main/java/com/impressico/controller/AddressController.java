package com.impressico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressico.entities.Address;
import com.impressico.services.impl.AddressServiceImpl;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;

	@PostMapping("/")
	public Address addAddress(@RequestBody Address address) {
		return this.addressServiceImpl.addAddress(address);
	}
	
	@GetMapping("/")
	public List<Address> getAddresses(){
		return this.addressServiceImpl.getAllAddresses();
	}
}
