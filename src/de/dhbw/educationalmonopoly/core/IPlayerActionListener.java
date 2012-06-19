/**
	EducationalMonopoly
	PlayerActionListener.java
	Apr 17, 2012
*/

package de.dhbw.educationalmonopoly.core;

import de.dhbw.educationalmonopoly.model.DiceRoll;
import de.dhbw.educationalmonopoly.model.Player;

public interface IPlayerActionListener {

	/**
	 * Called when a Player performed a dice roll
	 * 
	 * @param player the Player who performed the dice roll
	 * @param diceRoll the DiceRoll which was the result of this action
	 */
	public void playerDidRollDice(Player player, DiceRoll diceRoll);
	
	/**
	 * Called when the current Player ends her turn
	 * 
	 * @param player the Player which pressed the 'end turn' button
	 */
	public void playerDidEndTurn(Player player);
	
	/**
	 * Called when the Player has finished his interaction with a field
	 */
	public void playerDidCompleteFieldInteraction();
	
}
