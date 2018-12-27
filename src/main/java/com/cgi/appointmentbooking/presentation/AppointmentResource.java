package com.cgi.appointmentbooking.presentation;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.cgi.appointmentbooking.domain.Appointment;

public class AppointmentResource extends ResourceSupport {

	private final Long id;
	private final String branchOfficerName;
	private final String customerName;
	private final Date appointmentTime;
	private final double duration;

	public AppointmentResource(Appointment appointment) {
		id = appointment.getId();
		branchOfficerName = appointment.getBranchOfficerName();
		customerName = appointment.getCustomerName();
		appointmentTime = appointment.getAppointmentTime();
		duration = appointment.getDuration();
	}
	
	@JsonProperty("id")
	public Long getResourceId() {
		return id;
	}
	@JsonProperty("branchOfficerName")
	public String getBranchOfficerName() {
		return branchOfficerName;
	}
	@JsonProperty("customerName")
	public String getCustomerName() {
		return customerName;
	}
	@JsonProperty("appointmentTime")
	public Date getAppointmentTime() {
		return appointmentTime;
	}
	@JsonProperty("duration")
	public Double getDuration() {
		return duration;
	}
}
