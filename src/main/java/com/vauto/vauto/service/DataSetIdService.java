package com.vauto.vauto.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vauto.vauto.model.DataSet;

@Service
public class DataSetIdService {
	
	public String getDataSetId(){
		ResponseEntity<DataSet> responseDataSet = new RestTemplate().getForEntity(
				"http://vautointerview.azurewebsites.net/api/datasetId", DataSet.class);

		DataSet dataSet = responseDataSet.getBody();
		return dataSet.getDatasetId();
		
	}
	
}
