package com.ac1.events_restapi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.ac1.events_restapi.dto.AttendeeInsertDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_ATTENDEE")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Attendee extends BaseUser {

	private Double balance;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "ATTENDEE_USER_ID")
	private List<Ticket> tickets = new ArrayList<>();

	public Attendee() {

	}

	public Attendee(Attendee attendee) {
		setId(attendee.getId());
		setName(attendee.getName());
		setEmail(attendee.getEmail());
		setBalance(attendee.getBalance());
	}

	public Attendee(AttendeeInsertDTO attendeeInsertDTO) {
		super.setName(attendeeInsertDTO.getName());
		super.setEmail(attendeeInsertDTO.getEmail());
		this.balance = 0.0;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
	}

}
