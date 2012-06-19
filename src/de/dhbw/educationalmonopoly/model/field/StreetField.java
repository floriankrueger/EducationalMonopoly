package de.dhbw.educationalmonopoly.model.field;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.educationalmonopoly.model.Building;
import de.dhbw.educationalmonopoly.model.Player;

public class StreetField extends CollectableField implements IBuyable {

	private double price;
	private Player owner;
	private List<Building> buildings = new ArrayList<Building>();
	
	public List<Building> getBuildings() {
		return buildings;
	}

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
		if (this.owner == null) {
			buyer.subtractMoney(this.price);
			
			if (!buyer.isBankrupt()) {
				this.setOwner(buyer);
			}
		}
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public void addBuilding(Building building) {
		this.buildings.add(building);
	}

}
