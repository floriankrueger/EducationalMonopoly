/**
	EducationalMonopoly
	Dice.java
	Apr 16, 2012
*/

package de.dhbw.educationalmonopoly.model;

public class Dice {

	public DiceRoll roll() {
		int firstDice = this.randomNumber();
		int secondDice = this.randomNumber();
		
		// TODO : add to dice statistics
		
		return new DiceRoll(firstDice, secondDice);
	}
	
	private int randomNumber() {
		return 1 + (int)(Math.random() * 6);
	}
}
