package model.services;

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

}
