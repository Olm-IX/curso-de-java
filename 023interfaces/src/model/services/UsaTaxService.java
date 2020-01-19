package model.services;

public class UsaTaxService implements TaxService {

	@Override
	public double tax(double amount) {
		return amount*0.10;
	}

}
