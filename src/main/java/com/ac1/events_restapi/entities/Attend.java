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

@Entity
@Table(name = "TB_ATTEND")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Attend extends BaseUser {

	private Double balance;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "ATTEND_USER_ID")
	private List<Ticket> tickets = new ArrayList<>();

	public Attend() {

	}

	public Attend(Attend attend) {
		setId(attend.getId());
		setName(attend.getName());
		setEmail(attend.getEmail());
		setBalance(attend.getBalance());
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
