/**
	EducationalMonopoly
	Main.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.core;

import de.dhbw.educationalmonopoly.gameRepresentation.IGameRepresentation;
import de.dhbw.educationalmonopoly.gameRepresentation.SwingGameRepresentation;
import de.dhbw.educationalmonopoly.model.Game;

/**
 * @author fkrueger
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game(); 
		IGameRepresentation gameRepresentation = new SwingGameRepresentation();
		game.gameRepresenation = gameRepresentation;
		game.start(); 
	}

}
