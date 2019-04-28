package com.vauto.vauto.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vauto.vauto.model.Vehicle;
import com.vauto.vauto.model.Vehicles;

@Service
public class VehicleService {
	
	
	
	public List<String> getVehiclesList(String dataSetID){
		ResponseEntity<Vehicles> responseVehicles = new RestTemplate().getForEntity(
				"http://vautointerview.azurewebsites.net/api/{datasetid}/vehicles", Vehicles.class,
				dataSetID);

		return responseVehicles.getBody().getVehicleIds();
	}
	
	
	public Vehicle getVehicle(String dataSetID,String vehicleID){
		ResponseEntity<Vehicle> responseVehicles = new RestTemplate().getForEntity(
				"http://vautointerview.azurewebsites.net/api/{datasetid}/vehicles/{vehicleID}",
				Vehicle.class,
				dataSetID,
				vehicleID);

		return responseVehicles.getBody();
	}
	

}
