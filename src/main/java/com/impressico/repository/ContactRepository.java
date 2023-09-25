package com.impressico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impressico.entities.Contacts;

public interface ContactRepository extends JpaRepository<Contacts, Integer>{
	


}
