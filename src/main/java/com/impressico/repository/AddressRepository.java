package com.impressico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impressico.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
