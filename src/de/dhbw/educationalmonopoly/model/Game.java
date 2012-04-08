/**
	EducationalMonopoly
	Game.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.model;

import java.util.ArrayList;
import java.util.List;

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
	private List<Player> players;
	private int playerOnTurn;
	
	/**
	 * A reference to a game representation
	 */
	private IGameRepresentation gameRepresenation;
	
	{
		this.players = new ArrayList<Player>();
	}
	
	public Game(MonopolyType monopolyType) {
		this.playerOnTurn = 0;
	}
	
	/**
	 * Starts the game.
	 */
	public void start() {
		this.gameRepresenation.drawField();
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
		this.gameRepresenation.setGame(this);
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getPlayerOnTurn() {
		return playerOnTurn;
	}

	public void setPlayerOnTurn(int playerOnTurn) {
		this.playerOnTurn = playerOnTurn;
	}
}
