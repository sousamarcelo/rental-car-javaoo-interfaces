package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.RentalCar;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		try {
		System.out.println("Enter rental data: ");
		System.out.print("Car model: ");
		String model = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		
		RentalCar rentalCar = new RentalCar(start, finish, new Vehicle(model));
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoice(rentalCar);		
		
		System.out.println("INVOICE: ");
		System.out.println("Basic payment: " + String.format("%.2f", rentalCar.getInvoice().getBasicPayment()));
		System.out.println("Tax: " + String.format("%.2f", rentalCar.getInvoice().getTax()));
		System.out.println("Total payment: " + String.format("%.2f", rentalCar.getInvoice().totalPayment()));
		
		
		} catch (ParseException e) {
			System.out.println("error: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
