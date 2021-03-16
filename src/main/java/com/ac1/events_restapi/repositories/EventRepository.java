package com.ac1.events_restapi.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ac1.events_restapi.entities.Event;

import org.springframework.stereotype.Component;

@Component
public class EventRepository {

	public List<Event> getAllEvents() {
		Event event1 = new Event();
		event1.setId(1L);
		event1.setName("Palestra");
		event1.setDescription("Palestra sobre IOT");
		event1.setPlace("Facens");

		List<Event> list = new ArrayList<>();
		list.add(event1);

		return list;
	}
}
