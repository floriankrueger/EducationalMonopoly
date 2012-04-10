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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

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
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setLayout(new BorderLayout());
		mainWindow.setPreferredSize(new Dimension(1024,768));
		mainWindow.setResizable(false);
		mainWindow.setTitle("Educational Monopoly");
		
		Container pane = mainWindow.getContentPane();
		
		this.gameBoardPanel = new GameBoardPanel();
		this.gameBoardPanel.setPreferredSize(new Dimension(800,768));
		pane.add(this.gameBoardPanel, BorderLayout.LINE_START);
						
		this.playerActionPanel = new PlayerActionPanel();
		this.playerActionPanel.setPreferredSize(new Dimension(200,768));
		//this.playerActionPanel.revalidate();
		this.playerActionPanel.setBackground(new Color(255,0,0));
		
		pane.add(this.playerActionPanel, BorderLayout.LINE_END);
		
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
		gameBoardPanel.setGame(this.game); 
	}

}

