package com.ac1.events_restapi.dto;

import com.ac1.events_restapi.entities.TicketType;

public class TicketSellDTO {
	private TicketType type;
	private Long idAttendee;

	public TicketType getType() {
		return type;
	}

	public void setType(TicketType type) {
		this.type = type;
	}

	public Long getIdAttendee() {
		return idAttendee;
	}

	public void setIdAttendee(Long idAttendee) {
		this.idAttendee = idAttendee;
	}

}
