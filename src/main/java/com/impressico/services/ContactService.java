package com.impressico.services;

import java.util.List;

import com.impressico.entities.Contacts;

public interface ContactService {
	
	Contacts addContact(Contacts contacts);
	
	List<Contacts> getAllContacts();
	
	Contacts getContact(Integer id);
	
	Contacts updateContact(Integer id,Contacts contacts);

	void deleteContact(Integer id);
	
}
