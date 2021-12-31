package model.services;

import model.entities.Invoice;
import model.entities.RentalCar;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;
	
	public RentalService() {
		
	}
	
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;		
	}
	
	public double getPricePerHour() {
		return pricePerHour;
	}
	
	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	
	public double getPricePerDay() {
		return pricePerDay;
	}
	
	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	public TaxService getTaxService() {
		return taxService;
	}	
	
	public void processInvoice(RentalCar rentalCar) {
		Long start = rentalCar.getStart().getTime();
		Long finish = rentalCar.getFinish().getTime();
		double duration = (double) (finish - start) / 1000 / 60 / 60;
		double basePayment;
		
		if (duration <= 12.0) {
			basePayment = Math.ceil(duration) * pricePerHour;
		} else {
			basePayment = Math.ceil(duration/24) * pricePerDay;
		}
		
		double tax = taxService.tax(basePayment);
		
		rentalCar.setInvoice(new Invoice(basePayment, tax));
	}

}
