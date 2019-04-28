package com.vauto.vauto.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vauto.vauto.model.DealerList;
import com.vauto.vauto.model.Dealers;
import com.vauto.vauto.model.Vehicle;
import com.vauto.vauto.service.DataSetIdService;
import com.vauto.vauto.service.DealerService;
import com.vauto.vauto.service.VehicleService;

@RestController
public class VAutoResource {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	DealerService dealerService;
	
	@Autowired
	DataSetIdService dataSetIdService;
	
	@GetMapping("/test")
	public String  convertCurrency() {
		
		
	
		
		String dataSetId=dataSetIdService.getDataSetId();
		
		List<String> vehicleList=vehicleService.getVehiclesList(dataSetId);
		
		Map<String,List<Vehicle>> dealerMap=getDealerMapping(vehicleList,dataSetId);
		
		DealerList dealersList=new DealerList();
		dealersList.setDealers(getDealersList(dealerMap,dataSetId));
		
	   	return dealerService.Submit(dealersList, dataSetId) ;
	}
	
	private List<Dealers> getDealersList(Map<String,List<Vehicle>> dealerMap,String dataSetId){
		List<Dealers> dealers=new ArrayList<>();
		
	    for (Map.Entry<String,List<Vehicle>> entry : dealerMap.entrySet())  {
	    	Dealers dealer=new Dealers();
	    	dealer.setVehicle(entry.getValue());
	    	dealer.setDealerId(entry.getKey());
	    	dealer.setName(dealerService.getDealerName(dataSetId, entry.getKey()));
	    	System.out.println(dataSetId);
	    	dealers.add(dealer);
	    }
	    return dealers;
	}
	
	private Map<String,List<Vehicle>> getDealerMapping(List<String> vehicleList,String dataSetId){
		Map<String,List<Vehicle>> dealerMap=new HashMap<>();
		for(String vehicleId:vehicleList){
			Vehicle vehicle= vehicleService.getVehicle(dataSetId, vehicleId);
			if(dealerMap.get(vehicle.getDealerId())==null){
				List<Vehicle> list=new ArrayList<Vehicle>();
				list.add(vehicle);
				dealerMap.put(vehicle.getDealerId(), list);
				
			}
			else	{
				List<Vehicle> list=dealerMap.get(vehicle.getDealerId());
				list.add(vehicle);
				dealerMap.put(vehicle.getDealerId(), list);
			}
		}
		return dealerMap;
	}

}
