/**
	EducationalMonopoly
	Main.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.core;

import de.dhbw.educationalmonopoly.gameRepresentation.IGameRepresentation;
import de.dhbw.educationalmonopoly.gameRepresentation.swingUI.SwingGameRepresentation;
import de.dhbw.educationalmonopoly.model.Game;
import de.dhbw.educationalmonopoly.model.Game.MonopolyType;
import de.dhbw.educationalmonopoly.model.GameFactory;

/**
 * @author fkrueger
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create game
		Game game = GameFactory.createGameWithType(MonopolyType.CLASSIC);
		
		// create swing ui representation
		IGameRepresentation gameRepresentation = new SwingGameRepresentation();
		game.setGameRepresenation(gameRepresentation);
		
		// create two players
		game.addNewLocalPlayer("Bugs Bunny");
		game.addNewLocalPlayer("Duffy Duck");
		
		// start the game
		game.start();
	}

}
