package com.ac1.events_restapi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.ac1.events_restapi.dto.AdminInsertDTO;

@Entity
@Table(name = "TB_ADMIN")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Admin extends BaseUser {

	private String phoneNumber;

	@OneToMany(mappedBy = "admin")
	private List<Event> events = new ArrayList<>();

	public Admin() {

	}

	public Admin(Admin admin) {
		setId(admin.getId());
		setName(admin.getName());
		setEmail(admin.getEmail());
		setPhoneNumber(admin.getPhoneNumber());
	}

	public Admin(AdminInsertDTO adminInsertDTO) {
		super.setName(adminInsertDTO.getName());
		super.setEmail(adminInsertDTO.getEmail());
		this.phoneNumber = adminInsertDTO.getPhoneNumber();
		this.events = adminInsertDTO.getEvents();
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

	public void addEvents(Event event) {
		this.events.add(event);
	}

}
