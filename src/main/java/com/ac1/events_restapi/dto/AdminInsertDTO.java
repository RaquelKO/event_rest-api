package com.ac1.events_restapi.dto;

import java.util.ArrayList;
import java.util.List;

import com.ac1.events_restapi.entities.Event;

public class AdminInsertDTO {
	private String name;
	private String email;
	private String phoneNumber;
	private List<Event> events = new ArrayList<>();

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

	public List<Event> getEvents() {
		return events;
	}

	public void addEvent(Event event) {
		this.events.add(event);
	}

}
