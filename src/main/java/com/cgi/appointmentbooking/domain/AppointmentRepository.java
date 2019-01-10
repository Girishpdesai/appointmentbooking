package com.cgi.appointmentbooking.domain;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepository<T extends Identifiable> {
 //   private List<Appointment> elements = Collections.synchronizedList(new ArrayList<>());
	   private List<Appointment> elements = new ArrayList<Appointment>();

	protected void updateIfExists(Appointment original, Appointment updated) {
        original.setAppointmentTime(updated.getAppointmentTime());
        original.setBranchOfficerName(updated.getBranchOfficerName());
        original.setAppointmentTime(updated.getAppointmentTime());
        original.setCustomerName(updated.getCustomerName());
        original.setDuration(updated.getDuration());
    }
	@SuppressWarnings("unchecked")
	public List<Appointment> findAll (){
		
		try {
			
		//	Appointment appointment = mapper.readValue("resouces/AppointmentData.json", Appointment.class);
		//	System.out.println("Json object is" + appointment.getBranchOfficerName() );
			System.out.println("Inside the Repository method" );
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("src/main/resources/AppointmentData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray appointmentList = (JSONArray)jsonObject.get("Appointments");
            System.out.println("ReadValue is done"+ appointmentList.toString() );            
			//elements = mapper.readValue("resouces/AppointmentData.json", new TypeReference<List<Appointment>>(){});
			for (int i=0; i< appointmentList.size(); i++) {
				JSONObject objAppointmentDetails = (JSONObject)appointmentList.get(i);
				System.out.println("ReadValue1 is done"+ objAppointmentDetails.get("id") );
				Appointment appointmentObj = new Appointment();
				appointmentObj.setId(Long.parseLong((String) objAppointmentDetails.get("id")));
				appointmentObj.setCustomerName((String)objAppointmentDetails.get("customerName"));
				appointmentObj.setBranchOfficerName((String)objAppointmentDetails.get("branchOfficerName"));
				elements.add(appointmentObj);
			}
            
            System.out.println("ReadValue is done" );
			
		}catch(JsonGenerationException e) {
			e.printStackTrace();
		}catch(JsonMappingException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return elements;
		
	}

}
