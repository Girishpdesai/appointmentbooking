package com.cgi.appointmentbooking.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepository<T extends Identifiable> {
    private List<Appointment> elements = Collections.synchronizedList(new ArrayList<>());

	protected void updateIfExists(Appointment original, Appointment updated) {
        original.setAppointmentTime(updated.getAppointmentTime());
        original.setBranchOfficerName(updated.getBranchOfficerName());
        original.setAppointmentTime(updated.getAppointmentTime());
        original.setCustomerName(updated.getCustomerName());
        original.setDuration(updated.getDuration());
    }
	@SuppressWarnings("unchecked")
	public List<Appointment> findAll (){
		ObjectMapper mapper= new ObjectMapper();
		
		try {
			
		//	Appointment appointment = mapper.readValue("resouces/AppointmentData.json", Appointment.class);
		//	System.out.println("Json object is" + appointment.getBranchOfficerName() );
			System.out.println("Inside the Repository method" );
			
			elements = mapper.readValue("resouces/AppointmentData.json", ArrayList.class);
			System.out.println("ReadValue is done" );
			
		}catch(JsonGenerationException e) {
			e.printStackTrace();
		}catch(JsonMappingException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return elements;
		
	}
}
