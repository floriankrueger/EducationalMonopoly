package de.dhbw.educationalmonopoly.model.field;


public class TrainStationField extends Field {
	
	public enum TrainStationType {
		SOUTH,
		WEST,
		NORTH,
		MAIN
	}
	
	private TrainStationType type;
	
	public TrainStationField(String name, TrainStationType type) {
		super(name);
		this.setType(type);
	}

	public TrainStationType getType() {
		return type;
	}

	public void setType(TrainStationType type) {
		this.type = type;
	}
	
}
