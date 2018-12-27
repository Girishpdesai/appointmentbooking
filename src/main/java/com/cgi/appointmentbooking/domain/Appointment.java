package com.cgi.appointmentbooking.domain;

import java.util.Date;

public class Appointment implements Identifiable{

	private Long id;
	private String branchOfficerName;
	private String customerName;
	private Date appointmentTime;
	private double duration;
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getBranchOfficerName() {
		return branchOfficerName;
	}
	
	public void setBranchOfficerName(String branchOfficerName) {
		this.branchOfficerName = branchOfficerName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Date appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	
	
}
