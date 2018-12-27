package com.cgi.appointmentbooking.assembler;

import com.cgi.appointmentbooking.domain.Appointment;
import com.cgi.appointmentbooking.presentation.AppointmentResource;

public class AppointmentResourceAssembler extends ResourceAssembler<Appointment, AppointmentResource>{
	public AppointmentResource toResource(Appointment appointment) {
		AppointmentResource appointmentResource = new AppointmentResource(appointment);
		
		return appointmentResource;
		
	}
	

}
