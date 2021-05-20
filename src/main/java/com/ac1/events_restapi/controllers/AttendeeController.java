package com.ac1.events_restapi.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.ac1.events_restapi.dto.AttendeeDTO;
import com.ac1.events_restapi.dto.AttendeeInsertDTO;
import com.ac1.events_restapi.dto.AttendeeUpdateDTO;
import com.ac1.events_restapi.entities.Attendee;
import com.ac1.events_restapi.services.AttendeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {

	@Autowired
	private AttendeeService attendeeService;

	@GetMapping
	public ResponseEntity<Page<AttendeeDTO>> getAttendees(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<AttendeeDTO> list = attendeeService.getAttendees(pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {
		Attendee attendee = attendeeService.getAttendeeById(id);
		return ResponseEntity.ok().body(attendee);
	}

	@PostMapping
	public ResponseEntity<Attendee> insert(@Valid @RequestBody AttendeeInsertDTO attendeeInsertDTO) {
		Attendee dto = attendeeService.insert(attendeeInsertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Attendee> update(@Valid @RequestBody AttendeeUpdateDTO attendeeUpdateDto,
			@PathVariable Long id) {
		Attendee dto = attendeeService.update(id, attendeeUpdateDto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		attendeeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
