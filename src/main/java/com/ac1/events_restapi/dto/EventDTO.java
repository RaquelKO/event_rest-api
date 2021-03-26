package com.ac1.events_restapi.dto;

import com.ac1.events_restapi.entities.Event;

public class EventDTO {
	private Long id;
	private String name;

	public EventDTO() {

	}

	public EventDTO(Long id, String name) {
		setId(id);
		setName(name);
	}

	public EventDTO(Event event) {
		setId(event.getId());
		setName(event.getName());
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

}
