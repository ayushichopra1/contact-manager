package com.impressico.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "contacts")
public class Contacts {

	@Id
	private Integer id;

	@Column(name = "contact_name", nullable = false, length = 200)
	private String name;
	private String email;
	private String phone;
	private String alternatephone;
	
	@OneToMany(mappedBy = "contacts",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Address> address=new ArrayList<>();

	public Contacts() {
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Contacts(Integer id, String name, String email, String phone, String alternatephone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.alternatephone = alternatephone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAlternatephone() {
		return alternatephone;
	}

	public void setAlternatephone(String alternatephone) {
		this.alternatephone = alternatephone;
	}

}
