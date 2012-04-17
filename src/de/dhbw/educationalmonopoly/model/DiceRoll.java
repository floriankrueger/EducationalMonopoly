/**
	EducationalMonopoly
	DiceRoll.java
	Apr 16, 2012
*/

package de.dhbw.educationalmonopoly.model;

public class DiceRoll {

	private int firstDice, secondDice;
	
	private DiceRoll() {
		super();
	}
	
	public DiceRoll(int firstDice, int secondDice) {
		this();
		this.setFirstDice(firstDice);
		this.setSecondDice(secondDice);
	}

	public boolean isDoubles() {
		return (this.firstDice == this.secondDice);
	}
	
	public int value() {
		return this.firstDice + this.secondDice;
	}
	
	public int getFirstDice() {
		return firstDice;
	}

	public void setFirstDice(int firstDice) {
		this.firstDice = firstDice;
	}

	public int getSecondDice() {
		return secondDice;
	}

	public void setSecondDice(int secondDice) {
		this.secondDice = secondDice;
	}
	
	
}
