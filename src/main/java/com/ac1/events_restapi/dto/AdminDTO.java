package com.ac1.events_restapi.dto;

import com.ac1.events_restapi.entities.Admin;

public class AdminDTO {
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	// private List<Event> events = new ArrayList<>();

	public AdminDTO() {

	}

	public AdminDTO(Long id, String name, String email, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public AdminDTO(Admin admin) {
		setId(admin.getId());
		setName(admin.getName());
		setEmail(admin.getEmail());
		setPhoneNumber(admin.getPhoneNumber());

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
