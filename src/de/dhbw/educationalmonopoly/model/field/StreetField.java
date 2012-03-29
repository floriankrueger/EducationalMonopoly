package de.dhbw.educationalmonopoly.model.field;

import de.dhbw.educationalmonopoly.model.Player;

public class StreetField extends CollectableField implements IBuyable {

	private double price;
	private Player owner;
	
	public StreetField(String name, double price) {
		super(name);
		this.price = price;
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
