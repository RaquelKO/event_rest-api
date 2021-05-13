package com.ac1.events_restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ac1.events_restapi.dto.AdminDTO;
import com.ac1.events_restapi.dto.AdminInsertDTO;
import com.ac1.events_restapi.dto.AdminUpdateDTO;
import com.ac1.events_restapi.entities.Admin;
import com.ac1.events_restapi.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public List<AdminDTO> getAdmins() {
		List<Admin> list = adminRepository.findAll();
		List<AdminDTO> listDTO = new ArrayList<>();
		for (Admin admin : list) {
			listDTO.add(new AdminDTO(admin.getId(), admin.getName(), admin.getEmail(), admin.getPhoneNumber()));
		}

		return listDTO;
	}

	public Admin insert(AdminInsertDTO adminInsertDTO) {

		Admin entity = new Admin(adminInsertDTO);
		entity = adminRepository.save(entity);
		return new Admin(entity);
	}

	public Admin getAdminById(Long id) {

		Optional<Admin> op = adminRepository.findById(id);
		Admin admin = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found"));

		return new Admin(admin);
	}

	public Admin update(Long id, AdminUpdateDTO adminUpdateDto) {
		try {
			Admin entity = adminRepository.getOne(id);
			entity.setEmail(adminUpdateDto.getEmail());
			entity.setPhoneNumber(adminUpdateDto.getPhoneNumber());

			entity = adminRepository.save(entity);
			return new Admin(entity);
		} catch (EntityNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
		}
	}

	public void delete(Long id) {
		try {
			adminRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
		}
	}
}
