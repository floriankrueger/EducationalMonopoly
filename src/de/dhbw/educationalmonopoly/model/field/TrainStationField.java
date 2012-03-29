package de.dhbw.educationalmonopoly.model.field;

import de.dhbw.educationalmonopoly.model.Player;

public class TrainStationField extends CollectableField implements IBuyable {
	
	public enum TrainStationType {
		SOUTH,
		WEST,
		NORTH,
		MAIN
	}
	
	private TrainStationType type;
	private double price;
	private Player owner;
	
	public TrainStationField(String name, TrainStationType type, double price) {
		super(name);
		this.type = type;
		this.price = price;
	}

	public TrainStationType getType() {
		return type;
	}

	public void setType(TrainStationType type) {
		this.type = type;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public Player getOwner() {
		return this.owner;
	}

	@Override
	public boolean hasOwner() {
		return (this.owner != null);
	}

	@Override
	public void buy(Player buyer) {
		// TODO implement purchase process
	}
	
}
