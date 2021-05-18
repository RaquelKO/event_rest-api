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

@Entity
@Table(name = "TB_ATTENDEE")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Attendee extends BaseUser {

	private Double balance;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "ATTENDEE_USER_ID")
	private List<Ticket> tickets = new ArrayList<>();

	public Attendee() {

	}

	public Attendee(Attendee attend) {
		setId(attend.getId());
		setName(attend.getName());
		setEmail(attend.getEmail());
		setBalance(attend.getBalance());
	}

	public Attendee(AttendeeInsertDTO attendInsertDTO) {
		super.setName(attendInsertDTO.getName());
		super.setEmail(attendInsertDTO.getEmail());
		this.balance = attendInsertDTO.getBalance();
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
