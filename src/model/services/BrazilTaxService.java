package model.services;

public class BrazilTaxService implements TaxService {
	
	private static final double BASE_CALC = 100.0;

	@Override
	public double tax(double amount) {
		if (amount <= BASE_CALC) {
			return amount * 0.2;
		} else {
		return amount * 0.15;
		}
	}
}
