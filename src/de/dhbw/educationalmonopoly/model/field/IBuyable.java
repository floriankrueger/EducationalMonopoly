package de.dhbw.educationalmonopoly.model.field;

import de.dhbw.educationalmonopoly.model.Player;

public interface IBuyable {

	public double getPrice();
	public void setPrice(double price);
	
	public Player getOwner();
	public boolean hasOwner();
	public void buy(Player buyer);
	
}
