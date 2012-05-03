/**
	EducationalMonopoly
	IGameRepresentation.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.gameRepresentation;

import de.dhbw.educationalmonopoly.model.Game;
import de.dhbw.educationalmonopoly.model.Player;
import de.dhbw.educationalmonopoly.model.Token;

/**
 * @author benjamin
 */
public interface IGameRepresentation {
	
	/**
	 * Shows a menu from which a match can be started
	 */
	public void presentMenu();
	
	/**
	 * Draws the field in its current state
	 */
	public void drawField();
	
	/**
	 * Keeps a reference to the game board which is drawn
	 */
	public void setGame(Game game);

	/**
	 * Displays Information about the current player
	 */
	public void setCurrentPlayer(Player player);
	
	/**
	 * Provides a reference to a local instance of a <code>PlayerActionDelegate</code>
	 */
	public PlayerActionDelegate getPlayerActionDelegate();
	
	/**
	 * Moves the given token to a given field index. Optionally animates this transition.
	 */
	public void moveTokenToFieldIndexAnimated(Token token, int fieldIndex, boolean animated);
	
}
