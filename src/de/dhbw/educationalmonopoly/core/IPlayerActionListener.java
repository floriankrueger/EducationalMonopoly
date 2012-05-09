/**
	EducationalMonopoly
	PlayerActionListener.java
	Apr 17, 2012
*/

package de.dhbw.educationalmonopoly.core;

import de.dhbw.educationalmonopoly.model.DiceRoll;
import de.dhbw.educationalmonopoly.model.Player;

public interface IPlayerActionListener {

	public void playerDidRollDice(Player player, DiceRoll diceRoll);
	
}
