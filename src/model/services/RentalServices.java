package model.services;

import java.time.Duration;

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

	public void processInvoice(CarRental carRental) {

		double durMinutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double durHours = durMinutes / 60.00;
		
		double bp = 0;
		if (durHours <= 12.00) {
			bp = Math.ceil(durHours) * pricePerHour;
		}

		else {
			bp = Math.ceil(durHours / 24.0) * pricePerDay;
		}

		carRental.setInvoice(new Invoice(bp, taxService.tax(bp)));
	}

}
