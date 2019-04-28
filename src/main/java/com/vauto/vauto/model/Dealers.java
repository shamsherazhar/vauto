package com.vauto.vauto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dealers {
	String dealerId;
	String name;
	@JsonProperty("vehicles")
	List<Vehicle> vehicle;
	public String getDealerId() {
		return dealerId;
	}
	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public String toString() {
		return "Dealers [dealerId=" + dealerId + ", name=" + name + ", vehicle=" + vehicle + "]";
	}
	
	
	
	
} 
