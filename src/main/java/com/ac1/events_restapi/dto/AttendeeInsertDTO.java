package com.ac1.events_restapi.dto;

import javax.validation.constraints.NotBlank;

public class AttendeeInsertDTO {

	@NotBlank(message = "This field must not be blank!")
	private String name;

	@NotBlank(message = "This field must not be blank!")
	private String email;

	private Double balance;

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
