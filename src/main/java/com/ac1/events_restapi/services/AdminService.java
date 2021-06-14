package com.ac1.events_restapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.ac1.events_restapi.dto.AdminDTO;
import com.ac1.events_restapi.dto.AdminInsertDTO;
import com.ac1.events_restapi.dto.AdminUpdateDTO;
import com.ac1.events_restapi.entities.Admin;
import com.ac1.events_restapi.repositories.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Page<AdminDTO> getAdmins(PageRequest pageRequest) {
		Page<Admin> list = adminRepository.findAdminPageable(pageRequest);
		return list.map(admin -> new AdminDTO(admin));
	}

	public Admin insert(AdminInsertDTO adminInsertDTO) {

		Admin entity = new Admin(adminInsertDTO);
		for (Admin a : adminRepository.findAll()) {
			if (entity.getEmail().equals(a.getEmail())) {
				throw new ResponseStatusException(HttpStatus.FORBIDDEN,
						"This email address is already being used, please choose another one.");
			}
		}

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
			for (Admin a : adminRepository.findAll()) {
				if (adminUpdateDto.getEmail().equals(a.getEmail())) {
					throw new ResponseStatusException(HttpStatus.FORBIDDEN,
							"This email address is already being used, please choose another one.");
				}
			}
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
