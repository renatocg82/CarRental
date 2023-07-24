package model.entities;

public class Vehicle {
	
	String model;
	
	public Vehicle() {

	}
	
	public Vehicle(String name) {
		this.model = name;
	}

	public String getName() {
		return model;
	}

	public void setName(String name) {
		this.model = name;
	}
	
}
