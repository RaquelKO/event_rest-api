package com.ac1.events_restapi.repositories;

import com.ac1.events_restapi.entities.Attend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendRepository extends JpaRepository<Attend, Long> {

}
