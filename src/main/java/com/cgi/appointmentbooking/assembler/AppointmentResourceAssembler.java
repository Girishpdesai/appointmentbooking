package com.cgi.appointmentbooking.assembler;

import org.springframework.stereotype.Component;

import com.cgi.appointmentbooking.domain.Appointment;
import com.cgi.appointmentbooking.presentation.AppointmentResource;

@Component

public class AppointmentResourceAssembler extends ResourceAssembler<Appointment, AppointmentResource>{
	public AppointmentResource toResource(Appointment appointment) {
		AppointmentResource appointmentResource = new AppointmentResource(appointment);
		
		return appointmentResource;
		
	}
	

}
