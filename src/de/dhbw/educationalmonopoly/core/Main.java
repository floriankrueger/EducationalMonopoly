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
import de.dhbw.educationalmonopoly.model.field.Field;

/**
 * @author fkrueger
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = GameFactory.createGameWithType(MonopolyType.CLASSIC);
		IGameRepresentation gameRepresentation = new SwingGameRepresentation();
		game.setGameRepresenation(gameRepresentation);
		
		for (Field field : game.getGameBoard().getFields()) {
			System.out.println("Field : " + field.getClass().toString());
		}
		
		game.start(); 
	}

}
