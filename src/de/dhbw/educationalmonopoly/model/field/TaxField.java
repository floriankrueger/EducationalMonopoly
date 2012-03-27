package de.dhbw.educationalmonopoly.model.field;

public class TaxField extends Field {
	
	private double tax;
	
	public TaxField(String name, double tax) {
		this.tax = tax;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
}
