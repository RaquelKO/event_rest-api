package com.ac1.events_restapi.dto;

import com.ac1.events_restapi.entities.TicketType;

public class TicketListedDTO {

	private Long id;
	private TicketType type;
	private String attendeeName;

	public TicketListedDTO() {

	}

	public TicketListedDTO(Long id, TicketType type, String attendeeName) {
		this.id = id;
		this.type = type;
		this.attendeeName = attendeeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TicketType getType() {
		return type;
	}

	public void setType(TicketType type) {
		this.type = type;
	}

	public String getAttendeeName() {
		return attendeeName;
	}

	public void setAttendeeName(String attendeeName) {
		this.attendeeName = attendeeName;
	}

}
