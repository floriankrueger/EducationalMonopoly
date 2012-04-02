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
	
	public enum MonopolyType {
		CLASSIC
	}
	
	private GameBoard gameBoard;
	
	/**
	 * A reference to a game representation
	 */
	private IGameRepresentation gameRepresenation;
	
	public Game(MonopolyType monopolyType) {
		
	}
	
	/**
	 * Starts the game.
	 */
	public void start() {
		this.gameRepresenation.presentMenu();
	}
	
	public GameBoard getGameBoard() {
		return this.gameBoard;
	}
	
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public IGameRepresentation getGameRepresenation() {
		return gameRepresenation;
	}

	public void setGameRepresenation(IGameRepresentation gameRepresenation) {
		this.gameRepresenation = gameRepresenation;
		this.gameRepresenation.setGameBoard(this.gameBoard);
	}
}
