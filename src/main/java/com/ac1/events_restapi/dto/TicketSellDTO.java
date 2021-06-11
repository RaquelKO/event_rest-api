package com.ac1.events_restapi.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.ac1.events_restapi.entities.TicketType;

public class TicketSellDTO {

	@NotNull(message = "This field must not be null!")
	private TicketType type;

	@NotNull(message = "This field must not be null!")
	@PositiveOrZero(message = "This field must be a positive number!")
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
