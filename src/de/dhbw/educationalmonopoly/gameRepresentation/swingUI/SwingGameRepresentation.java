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
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	} 

	@Override 
	public void drawField() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void presentMenu() {
		JFrame mainWindow = new JFrame();
		mainWindow.setSize(1024,768);
		mainWindow.setVisible(true); 
		mainWindow.setTitle("Educational Monopoly");
		
		GameBoardPanel gamePanel = new GameBoardPanel();
		gamePanel.setFields(this.gameBoard.getFields()); 
		
		mainWindow.add(gamePanel);  
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

}

