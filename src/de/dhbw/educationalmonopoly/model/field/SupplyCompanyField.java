package de.dhbw.educationalmonopoly.model.field;

public class SupplyCompanyField extends Field {

	public enum SupplyCompanyType {
		WATER_WORKS,
		ELECTRIC_COMPANY
	}
	
	private SupplyCompanyType type; 
	
	public SupplyCompanyField(String name, SupplyCompanyType type) {
		super(name);
		this.setType(type);
	}

	public SupplyCompanyType getType() {
		return type;
	}

	public void setType(SupplyCompanyType type) {
		this.type = type;
	}
}
