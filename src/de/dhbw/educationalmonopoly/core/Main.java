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

		// extract dimensional values from the strings array
		int height = -1;
		int width = -1;

		try {
			
			// parse width
			if (args.length == 1) {
				
				// parse width
				width = Integer.parseInt(args[0]);
				
				// calculate heigth
				height = (int)(width * 0.75);
				
			}

			// parse width & height
			else if (args.length == 2) {

				// parse width
				width = Integer.parseInt(args[0]);

				// parse height
				height = Integer.parseInt(args[1]);

			}

		} catch (NumberFormatException nfe) {

			System.out.println("Unsupported Command Line Parameters (2). Ignoring.");

		}

		// create swing ui representation
		IGameRepresentation gameRepresentation;

		if ((width != -1) && (height != -1)) {
			gameRepresentation = new SwingGameRepresentation(width, height);
		} else {
			gameRepresentation = new SwingGameRepresentation();
		}
		game.setGameRepresenation(gameRepresentation);

		// create two players
		game.addNewLocalPlayer("Bugs Bunny");
		game.addNewLocalPlayer("Duffy Duck");

		// start the game
		game.start();
	}

}
