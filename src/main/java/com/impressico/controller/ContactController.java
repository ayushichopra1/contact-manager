package com.impressico.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impressico.entities.Contacts;
import com.impressico.services.impl.ContactServiceImpl;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	@Autowired
	private ContactServiceImpl contactServiceImpl;
	
	@PostMapping("/")
	public Contacts addContacts(@RequestBody Contacts contacts) {
		return this.contactServiceImpl.addContact(contacts);
	}
	
	@GetMapping("/")
	public List<Contacts> getContacts(){
		return this.contactServiceImpl.getAllContacts();
	}
	
	@GetMapping("/{id}")
	public Contacts getContact(@PathVariable Integer id) {
		return this.contactServiceImpl.getContact(id);
	}
	
	@PutMapping("/{id}")
	public Contacts updateContacts(@PathVariable Integer id,@RequestBody Contacts contacts){
		return this.contactServiceImpl.updateContact(id, contacts);
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Object>> deleteContact(@PathVariable  Integer id){
		this.contactServiceImpl.deleteContact(id);
		return new ResponseEntity<>(Map.of("message", "student deleted successfully"), HttpStatus.OK);
	}
	
	
}
