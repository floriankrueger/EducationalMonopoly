/**
	EducationalMonopoly
	SwingGameRepresentation.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.gameRepresentation.swingUI;

import java.awt.Color;
import javax.swing.JFrame;

import de.dhbw.educationalmonopoly.gameRepresentation.IGameRepresentation;
import de.dhbw.educationalmonopoly.model.Game;

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
		this.mainWindow = new JFrame();
		mainWindow.setSize(1024,768);
		mainWindow.setVisible(true); 
		mainWindow.setTitle("Educational Monopoly");
		
		//FlowLayout mgr = new FlowLayout(BoxLayout.Y_AXIS);
		//this.mainWindow.setLayout(mgr);
		
		this.gameBoardPanel = new GameBoardPanel();
		this.gameBoardPanel.setSize(800,768);
						
		this.playerActionPanel = new PlayerActionPanel();
		this.playerActionPanel.setSize(200, 768);
		this.playerActionPanel.revalidate();
		this.playerActionPanel.setBackground(new Color(255,0,0));
		
		mainWindow.getContentPane().add(this.gameBoardPanel);  
		mainWindow.getContentPane().add(this.playerActionPanel);

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
		gameBoardPanel.setGame(this.game); 
	}

}

