package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalServices {

	private Double pricePerDay;
	private Double pricePerHour;

	private BrazilTaxService taxService;
	
	public RentalServices(Double pricePerDay, Double pricePerHour, BrazilTaxService taxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}


	
	public void processInvoice (CarRental carRental) {
		
		 
		carRental.setInvoice(new Invoice(50.0 , 10.0));
	}
	
}
