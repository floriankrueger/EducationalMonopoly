/**
	EducationalMonopoly
	SwingGameRepresentation.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.gameRepresentation.swingUI;

import javax.swing.JFrame;

import de.dhbw.educationalmonopoly.gameRepresentation.IGameRepresentation;
import de.dhbw.educationalmonopoly.model.GameBoard;


/**
 * @author benjamin
 *
 */
public class SwingGameRepresentation implements IGameRepresentation {

	private GameBoard gameBoard;
	private JFrame mainWindow;
	private GameBoardPanel gameBoardPanel;
	
	@Override
	public void initialize() {
		this.mainWindow = new JFrame();
		mainWindow.setSize(1024,768);
		mainWindow.setVisible(true); 
		mainWindow.setTitle("Educational Monopoly");
		
		this.gameBoardPanel = new GameBoardPanel();
		gameBoardPanel.setGameBoard(this.gameBoard); 
		
		mainWindow.add(gameBoardPanel);  		
	} 

	@Override 
	public void drawField() {
		this.gameBoardPanel.repaint();
	}

	@Override
	public void presentMenu() {

	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

}

