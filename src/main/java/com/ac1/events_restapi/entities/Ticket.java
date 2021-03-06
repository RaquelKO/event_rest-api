package com.ac1.events_restapi.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ac1.events_restapi.dto.TicketSellDTO;

@Entity
@Table(name = "TB_TICKET")
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Instant date;
	private Double price;
	private TicketType type;

	@Transient
	private Long idAttendee;

	public Ticket() {

	}

	public Ticket(Ticket ticket) {
		setId(ticket.getId());
		setDate(ticket.getDate());
		setPrice(ticket.getPrice());
		setType(ticket.getType());
		setIdAttendee(ticket.getIdAttendee());
	}

	public Ticket(TicketSellDTO ticketSellDTO) {
		this.type = ticketSellDTO.getType();
		this.idAttendee = ticketSellDTO.getIdAttendee();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
