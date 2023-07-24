package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalServices;


public class AppCarRental {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		Scanner scString = new Scanner (System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		
		System.out.println("Entre com os dados do aluguel: ");
		System.out.print("Modelo do carro: ");
		String tempModel = sc.nextLine();
		System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime tempStart = LocalDateTime.parse(sc.nextLine(), dtf);
		System.out.print("Devolução (dd/MM/yyyy hh:mm): ");
		LocalDateTime tempFinish = LocalDateTime.parse(sc.nextLine(), dtf);
		
		CarRental carRental = new CarRental(tempStart, tempFinish, new Vehicle(tempModel));
		
		System.out.print("Entre com preço por hora: ");
		double tempPricePerHour = sc.nextDouble();
		System.out.print("Entre com preço por dia: ");
		double tempPricePerDay = sc.nextDouble();
		
		RentalServices rentalService = new RentalServices (tempPricePerDay, tempPricePerHour, new BrazilTaxService());
		rentalService.processInvoice(carRental);
		
		System.out.println("FATURA: ");
		System.out.println("Pagamento básico: ");
		System.out.println("Imposto: ");
		System.out.println("");
		 
		scString.close();
		sc.close();
	}

}
