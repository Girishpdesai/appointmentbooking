package com.cgi.appointmentbooking.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.appointmentbooking.assembler.AppointmentResourceAssembler;
import com.cgi.appointmentbooking.domain.Appointment;
import com.cgi.appointmentbooking.domain.AppointmentRepository;
import com.cgi.appointmentbooking.presentation.AppointmentResource;;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Appointment.class)
@RequestMapping(value = "/appointment", produces = "application/json")
public class AppointmentController {

	@Autowired
	private AppointmentRepository<Appointment> repository;

	@Autowired
	private AppointmentResourceAssembler assembler;
	
	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<Collection<AppointmentResource>> findAllAppointments(){
		List<Appointment> appointments = repository.findAll();
		return new ResponseEntity<>(assembler.toResourceCollection(appointments), HttpStatus.OK);
		
	}
}
