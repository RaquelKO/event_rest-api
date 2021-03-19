package com.ac1.events_restapi.controllers;

import java.util.List;

import com.ac1.events_restapi.dto.EventDTO;
import com.ac1.events_restapi.entities.Event;
import com.ac1.events_restapi.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService service;

	@GetMapping
	public ResponseEntity<List<EventDTO>> getAllEvents() {
		List<EventDTO> list = service.getAllEvents();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id) {
		Event event = service.getEventById(id);
		return ResponseEntity.ok().body(event);
	}
}
