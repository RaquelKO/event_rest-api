package com.ac1.events_restapi.controllers;

import java.net.URI;
import java.util.List;

import com.ac1.events_restapi.dto.AttendDTO;
import com.ac1.events_restapi.dto.AttendInsertDTO;
import com.ac1.events_restapi.dto.AttendUpdateDTO;
import com.ac1.events_restapi.entities.Attend;
import com.ac1.events_restapi.services.AttendService;

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
@RequestMapping("/attends")
public class AttendController {

	@Autowired
	private AttendService attendService;

	@GetMapping
	public ResponseEntity<List<AttendDTO>> getAttends() {
		List<AttendDTO> list = attendService.getAttends();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Attend> getAttendById(@PathVariable Long id) {
		Attend event = attendService.getAttendById(id);
		return ResponseEntity.ok().body(event);
	}

	@PostMapping
	public ResponseEntity<Attend> insert(@RequestBody AttendInsertDTO attendInsertDTO) {
		Attend dto = attendService.insert(attendInsertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Attend> update(@RequestBody AttendUpdateDTO attendUpdateDto, @PathVariable Long id) {
		Attend dto = attendService.update(id, attendUpdateDto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		attendService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
