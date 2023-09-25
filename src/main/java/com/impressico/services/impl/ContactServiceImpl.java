package com.impressico.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impressico.entities.Contacts;
import com.impressico.repository.ContactRepository;
import com.impressico.services.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contacts addContact(Contacts contacts) {
		Contacts contacts2 = this.contactRepository.save(contacts);
		return contacts2;
	}

	@Override
	public List<Contacts> getAllContacts() {
		return this.contactRepository.findAll();
	}

	@Override
	public Contacts getContact(Integer id) {
		return this.contactRepository.findById(id).get();
	}

	@Override
	public Contacts updateContact(Integer id, Contacts contacts) {

		contacts.setId(id);
		return this.contactRepository.save(contacts);
	}

	@Override
	public void deleteContact(Integer id) {
	 Contacts contacts=	this.contactRepository.findById(id).get();
	 contactRepository.delete(contacts);
	}

	

}
