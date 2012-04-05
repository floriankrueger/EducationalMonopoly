/**
	EducationalMonopoly
	IGameRepresentation.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.gameRepresentation;

import de.dhbw.educationalmonopoly.model.Game;

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

}
