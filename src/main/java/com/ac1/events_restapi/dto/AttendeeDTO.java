package com.ac1.events_restapi.dto;

import com.ac1.events_restapi.entities.Attendee;

public class AttendeeDTO {
	private Long id;
	private String name;
	private String email;
	private Double balance;

	public AttendeeDTO() {

	}

	public AttendeeDTO(Long id, String name, String email, Double balance) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
	}

	public AttendeeDTO(Attendee attend) {
		setId(attend.getId());
		setName(attend.getName());
		setEmail(attend.getEmail());
		setBalance(attend.getBalance());
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
