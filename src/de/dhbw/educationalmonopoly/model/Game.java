/**
	EducationalMonopoly
	Game.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.model;

import de.dhbw.educationalmonopoly.gameRepresentation.IGameRepresentation;

/**
 * @author benjamin
 *
 */
public class Game {
	
	/**
	 * A reference to a game representation
	 */
	public IGameRepresentation gameRepresenation;
	
	public Game() {
		
	}
	
	/**
	 * Starts the game.
	 */
	public void start() {
		this.gameRepresenation.presentMenu();
	}
}
