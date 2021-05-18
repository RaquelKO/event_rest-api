package com.ac1.events_restapi.repositories;

import com.ac1.events_restapi.entities.Attendee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

}
