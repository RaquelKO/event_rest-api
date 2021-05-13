package com.ac1.events_restapi.controllers;

import java.net.URI;
import java.util.List;

import com.ac1.events_restapi.dto.AdminDTO;
import com.ac1.events_restapi.dto.AdminInsertDTO;
import com.ac1.events_restapi.dto.AdminUpdateDTO;
import com.ac1.events_restapi.entities.Admin;
import com.ac1.events_restapi.services.AdminService;

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
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping
	public ResponseEntity<List<AdminDTO>> getAdmins() {
		List<AdminDTO> list = adminService.getAdmins();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
		Admin event = adminService.getAdminById(id);
		return ResponseEntity.ok().body(event);
	}

	@PostMapping
	public ResponseEntity<Admin> insert(@RequestBody AdminInsertDTO adminInsertDTO) {
		Admin dto = adminService.insert(adminInsertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping("{id}")
	public ResponseEntity<Admin> update(@RequestBody AdminUpdateDTO adminUpdateDto, @PathVariable Long id) {
		Admin dto = adminService.update(id, adminUpdateDto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		adminService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
