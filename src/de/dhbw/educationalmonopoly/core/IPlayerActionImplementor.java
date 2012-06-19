/**
	EducationalMonopoly
	PlayerActionImplementor.java
	Apr 16, 2012
*/

package de.dhbw.educationalmonopoly.core;

import de.dhbw.educationalmonopoly.model.DiceRoll;
import de.dhbw.educationalmonopoly.model.Player;
import de.dhbw.educationalmonopoly.model.field.Field;

public interface IPlayerActionImplementor {

	/**
	 * Keeps a reference to its player
	 * 
	 * @param player
	 */
	public void setPlayer(Player player);
	
	// ACTION REQUEST METHODS
	public void rollDice();
	public void performFieldInteraction(Field field);
	
	// DELEGATE CALLBACKS
	public void playerDidRollDice(DiceRoll diceRoll);
	public void playerDidPerformFieldInteraction();
	public void playerDidEndTurn();
	
	// OBSERVER
	public void addPlayerActionListener(IPlayerActionListener listener);
	public void removePlayerActionListener(IPlayerActionListener listener); 
}
