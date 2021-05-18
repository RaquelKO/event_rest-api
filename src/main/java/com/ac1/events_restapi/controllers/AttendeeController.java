package com.ac1.events_restapi.controllers;

import java.net.URI;
import java.util.List;

import com.ac1.events_restapi.dto.AttendeeDTO;
import com.ac1.events_restapi.dto.AttendeeInsertDTO;
import com.ac1.events_restapi.dto.AttendeeUpdateDTO;
import com.ac1.events_restapi.entities.Attendee;
import com.ac1.events_restapi.services.AttendeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {

	@Autowired
	private AttendeeService attendeeService;

	@GetMapping
	public ResponseEntity<List<AttendeeDTO>> getAttendees() {
		List<AttendeeDTO> list = attendeeService.getAttendees();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {
		Attendee attendee = attendeeService.getAttendeeById(id);
		return ResponseEntity.ok().body(attendee);
	}

	@PostMapping
	public ResponseEntity<Attendee> insert(@RequestBody AttendeeInsertDTO attendeeInsertDTO) {
		Attendee dto = attendeeService.insert(attendeeInsertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Attendee> update(@RequestBody AttendeeUpdateDTO attendeeUpdateDto, @PathVariable Long id) {
		Attendee dto = attendeeService.update(id, attendeeUpdateDto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		attendeeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
