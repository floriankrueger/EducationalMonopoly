/**
	EducationalMonopoly
	SwingGameRepresentation.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.gameRepresentation.swingUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;

import de.dhbw.educationalmonopoly.gameRepresentation.IGameRepresentation;
import de.dhbw.educationalmonopoly.gameRepresentation.PlayerActionDelegate;
import de.dhbw.educationalmonopoly.model.DiceRoll;
import de.dhbw.educationalmonopoly.model.Game;
import de.dhbw.educationalmonopoly.model.Player;
import de.dhbw.educationalmonopoly.model.Token;

/**
 * @author benjamin
 *
 */
public class SwingGameRepresentation implements IGameRepresentation {

	private Game game;
	private JFrame mainWindow;
	private GameBoardPanel gameBoardPanel;
	private PlayerActionPanel playerActionPanel;
	
	{
		// create main window
		this.mainWindow = new JFrame();
		mainWindow.setTitle("Educational Monopoly");
		
		// set Layout Manager to BorderLayout (this is default anyways)
		mainWindow.setLayout(new BorderLayout());
		
		// specify the size for the main window and prevent the user from resizing it
		mainWindow.setPreferredSize(new Dimension(1024,768));
		mainWindow.setResizable(false);
		
		// once the main window is closed the program should end
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// retrieve the container from the main window where all 
		// other components should be put on
		Container pane = mainWindow.getContentPane();
		
		// create game board panel and set the dimensions
		this.gameBoardPanel = new GameBoardPanel();
		this.gameBoardPanel.setPreferredSize(new Dimension(768,768));
		
		// add the game board panel to the container and glue it to the left border
		pane.add(this.gameBoardPanel, BorderLayout.LINE_START);
						
		// create the player action panel and set the dimensions
		this.playerActionPanel = new PlayerActionPanel();
		this.playerActionPanel.setPreferredSize(new Dimension(256,768));
		
		// DEBUG
		this.playerActionPanel.setBackground(new Color(102,102,102));
		
		// add the action panel to the container and glue it to the right border
		pane.add(this.playerActionPanel, BorderLayout.LINE_END);
		
		// apply all dimensions and layouts and show the main window
		mainWindow.pack();
		mainWindow.setVisible(true); 
	}

	@Override 
	public void drawField() {
		this.gameBoardPanel.repaint();
	}

	@Override
	public void presentMenu() {

	}

	@Override
	public void setGame(Game game) {
		this.game = game;
		this.gameBoardPanel.setGame(this.game);
		this.playerActionPanel.setGame(this.game);
	}

	@Override
	public void setCurrentPlayer(Player player) {
		this.playerActionPanel.setCurrentPlayer(player);
	}
	
	@Override
	public PlayerActionDelegate getPlayerActionDelegate() {
		return this.playerActionPanel;
	}

	/*
	 * Token Movement Methods
	 * 
	 */
	
	@Override
	public void moveTokenToFieldIndexAnimated(final Token token, final int fieldIndex,
			boolean animated) {
				
		// we want to control the animation from a background thread, not blocking the UI
		Runnable doWorkRunnable = new Runnable() {
		    public void run() { animateFieldTransition(token, fieldIndex); }
		};
		
		new Thread(doWorkRunnable).start();
	}

	private void animateFieldTransition(Token token, int fieldIndex) {
		System.out.println("Animation moving Tokens began.");
		
		while (token.getFieldIndex() != fieldIndex) {
			// we need to keep on moving forward
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// could not slow down animation
				e.printStackTrace();
			}
			
			int oldFieldIndex = token.getFieldIndex();
			int newFieldIndex = oldFieldIndex+1;
			
			if (newFieldIndex == game.getGameBoard().getFields().size()) {
				newFieldIndex = 0;
			}
			token.setFieldIndex(newFieldIndex);
			this.gameBoardPanel.repaint();
		}
		
		// inform, that movement is complete
		this.tokenMovementCompleted();
	}
	
	private void tokenMovementCompleted() {
		System.out.println("Animation moving Tokens completed.");

		// inform game, that movement completed
		this.game.tokenMovementCompleted();
	}

	/*
	 * GAME STATE DISPLAY 
	 */
	
	@Override
	public void displayDiceRoll(DiceRoll diceRoll) {
		this.playerActionPanel.getMatchInfoLabel().setText("Dice Roll: "+diceRoll.getFirstDice()+", "+diceRoll.getSecondDice());
	}
}

