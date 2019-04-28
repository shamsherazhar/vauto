package com.vauto.vauto.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vauto.vauto.model.Dealer;
import com.vauto.vauto.model.DealerList;

@Service
public class DealerService {
	public String getDealerName(String dataSetId,String dealerID){
		ResponseEntity<Dealer> responseDataSet = new RestTemplate().getForEntity(
				"http://vautointerview.azurewebsites.net/api/{datasetid}/dealers/{dealerid}", Dealer.class,
				dataSetId,
				dealerID);

		return responseDataSet.getBody().getName();
	}
	
	public String Submit( DealerList dealerList,String dataSetId){
		
		  final String baseUrl = "http://vautointerview.azurewebsites.net/api/"+dataSetId+"/answer";
		   
		ResponseEntity<String> responseDataSet = new RestTemplate().postForEntity(
				baseUrl, dealerList,String.class
				);

		return responseDataSet.getBody();
	}
	
}
