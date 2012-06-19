/**
	EducationalMonopoly
	Game.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.model;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.educationalmonopoly.core.IPlayerActionListener;
import de.dhbw.educationalmonopoly.gameRepresentation.IGameRepresentation;
import de.dhbw.educationalmonopoly.model.field.Field;
import de.dhbw.educationalmonopoly.model.field.IBuyable;

/**
 * @author benjamin
 *
 */
public class Game implements IPlayerActionListener {
	
	public enum MonopolyType {
		CLASSIC
	} 
	
	public enum MonopolyTurnPhase {
		ROLL_DICE,
		REACT
	}
	
	/**
	 * A reference to a game representation
	 */
	private IGameRepresentation gameRepresenation;
	
	private MonopolyType type;
	private GameBoard gameBoard;
	private List<Player> players;
	private Bank bank;
	private Player winner;
	private Dice dice;
	private DiceRoll lastDiceRoll;
	private int lastTargetFieldIndex;
	
	// CURRENT TURN DATA
	
	/**
	 * Number of current turn
	 */
	private int turn;

	/**
	 * A reference to the current <code>Player</code>
	 */
	private Player playerOnTurn;
	
	/** 
	 * The index of the current <code>Player</code>
	 */
	private int playerOnTurnIndex;
	
	/**
	 * The number of dice rolls in the current turn
	 */
	private int currentDiceRollCount;
	
	{
		this.players = new ArrayList<Player>();
	}
	
	public Game(MonopolyType monopolyType) {
		this.type = monopolyType;
		this.playerOnTurnIndex = 0;
		this.turn = 0;
		this.winner = null;
	}
	
	public void addNewLocalPlayer(String name) {
		Player localPlayer = PlayerFactory.createLocalPlayer(this, name);
		this.addPlayer(localPlayer);
	}
	
	// GAME CONTROL
	
	/**
	 * Starts the game.
	 */
	public void start() {
		// TODO : notify game representation
		System.out.println("game will start");
		
		// set turn number to 0
		this.turn = 0;
		
		// set all players to field 0
		for (Player p : this.getPlayers()) {
			p.getToken().setFieldIndex(0);
		}
		
		// draw tokens at initial position
		this.gameRepresenation.drawField();
		
		// TODO : notify game representation
		System.out.println("game did start");
		
		// start first round
		this.startTurn();
	}
	
	/**
	 * Ends the game.
	 */
	public void end() {
		// TODO : notify game representation
		System.out.println("game will end");
		
		// TODO : do something with the game result
		
		// TODO : notify game representation
		System.out.println("game did end");
	}
	
	// TURN CONTROL
	
	private void startTurn() {
		// TODO : notify game representation
		System.out.println("turn " + this.turn + " will start");
		
		// reset turn data
		this.currentDiceRollCount = 0;
		
		// find currentPlayer
		this.playerOnTurn = this.nextPlayer();
		
		// observe currentPlayer's actions
		this.playerOnTurn.getActionImplementor().addPlayerActionListener(this);
		
		// TODO : notify game representation
		System.out.println("turn " + this.turn + " did start ('" + this.playerOnTurn.getName() + "')");
		
		// represent game state
		this.gameRepresenation.setCurrentPlayer(this.playerOnTurn);
		this.gameRepresenation.drawField();
		
		// query player action
		this.waitForDiceRoll();
	}
	
	private void waitForDiceRoll() {
		// TODO : notify game representation
		System.out.println("waiting for '" + this.playerOnTurn.getName() + "' to roll the dice");
		
		this.playerOnTurn.getActionImplementor().rollDice();
	}
	
	public void playerDidRollDice(Player player, DiceRoll diceRoll) {
		// store diceRoll
		this.lastDiceRoll = diceRoll;
		
		this.gameRepresenation.displayDiceRoll(diceRoll);
		
		// count the dice rolls in current turn
		this.currentDiceRollCount++;
		
		int fieldIndex = this.playerOnTurn.getToken().getFieldIndex() + diceRoll.value();
		int gameBoardSize = this.gameBoard.getFields().size();
		
		// player moved over start
		while (gameBoardSize <= fieldIndex) {
			// pay salary
			this.playerDidCompleteRound();
			fieldIndex -= gameBoardSize;
		}
		
		this.lastTargetFieldIndex = fieldIndex;
		
		// when animation completes, tokenMovementCompleted() is called
		this.gameRepresenation.moveTokenToFieldIndexAnimated(this.playerOnTurn.getToken(), this.lastTargetFieldIndex, true);
	}
	
	public void tokenMovementCompleted() {
		// set token to final position
		this.playerOnTurn.getToken().setFieldIndex(this.lastTargetFieldIndex);
		
		Field currentField = this.gameBoard.getFields().get(this.lastTargetFieldIndex);
		this.waitForFieldInteraction(currentField);
		
		// re-roll the dice if last roll was doubles
		if ((this.currentDiceRollCount < 3) && (this.lastDiceRoll.isDoubles())) {
			this.waitForDiceRoll();
		} else {
			this.endTurn();
		}
	}
	
	private void waitForFieldInteraction(Field field) {
		
		// TODO : notify game representation
		System.out.println("waiting for '" + this.playerOnTurn.getName() + "' to take actions");
		
		this.playerOnTurn.getActionImplementor().performFieldInteraction(field);
		
		// FIXME remove this example code
		/*
		if (field instanceof IBuyable) {
			// cast the field
			IBuyable myField = (IBuyable) field;
			if (myField.hasOwner()) {
				//TODO: charge fee if houses or hotels exist
			} else {
				//TODO: offer player to buy street
				myField.buy(this.playerOnTurn);
				System.out.println(this.playerOnTurn.getName()+" purchased "+field.getName());
			}
		}
		*/
	}
	
	public void playerDidCompleteFieldInteraction() {
		
	}
	
	public void endTurn() {
		// TODO : notify game representation
		System.out.println("turn will end");
		
		// stop observing currentPlayer's actions
		playerOnTurn.getActionImplementor().removePlayerActionListener(this);
		
		// check for winner
		this.winner = this.checkForWinner();
		
		// TODO : notify game representation
		System.out.println("turn did end");
		
		// if there is no winner yet start next turn
		if (null == winner) {
			this.turn++;
			this.startTurn();
		} else {
			this.end();
		}
	}
	
	/**
	 * Increments the <code>playerOnTurn</code> variable until it matches a
	 * non-bankrupt player.
	 * 
	 * @return Player the next non-bankrupt player
	 */
	private Player nextPlayer() {
		Player nextPlayer = null;
		
		while (null == nextPlayer) {
			
			// find next valid index
			this.playerOnTurnIndex++;
			if (this.getPlayers().size() <= this.playerOnTurnIndex) {
				this.playerOnTurnIndex = 0;
			}
			
			Player p = this.getPlayers().get(this.playerOnTurnIndex);
			if (!p.isBankrupt()) {
				nextPlayer = p;
			}
			
		}
		
		return nextPlayer;
	}
	
	/**
	 * Checks for a winner
	 * 
	 * @return Player the player who has won or <code>null</code>
	 */
	private Player checkForWinner() {
		Player winner = null;
		
		List <Player> inGamePlayers = new ArrayList<Player>();
		
		// find all Players that are not bankrupt
		for (Player p : this.getPlayers()) {
			if (!p.isBankrupt()) {
				inGamePlayers.add(p);
			}
		}
		
		// check for winner
		if (1 == inGamePlayers.size()) {
			winner = inGamePlayers.get(0);
		}
		
		return winner;
	}
	
	private void playerDidCompleteRound() {
		// TODO : notify game representation
		System.out.println("player did complete round");

		// TODO : check for success (payPlayer already returns a boolean)
		this.bank.payPlayer(this.playerOnTurn, 2000);
	}
	
	public GameBoard getGameBoard() {
		return this.gameBoard;
	}
	
	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public MonopolyType getMonopolyType() {
		return this.type;
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

	public int getPlayerOnTurnIndex() {
		return playerOnTurnIndex;
	}

	public void setPlayerOnTurnIndex(int playerOnTurn) {
		this.playerOnTurnIndex = playerOnTurn;
	}

	public Player getPlayerOnTurn() {
		return playerOnTurn;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public Player getWinner() {
		return this.winner;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public int getTurn() {
		return turn;
	}
}
