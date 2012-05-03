/**
	EducationalMonopoly
	PlayerActionPanel.java
	08.04.2012
*/

package de.dhbw.educationalmonopoly.gameRepresentation.swingUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.dhbw.educationalmonopoly.gameRepresentation.PlayerActionDelegate;
import de.dhbw.educationalmonopoly.model.DiceRoll;
import de.dhbw.educationalmonopoly.model.Game;
import de.dhbw.educationalmonopoly.model.Player;

public class PlayerActionPanel extends JPanel implements ActionListener, PlayerActionDelegate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Game Components
	private Game game;
	
	// UI Components
	private JLabel headerLabel;
	private JButton diceButton;
	private JPanel currentPlayerContainer;
	private JLabel currentPlayerHeader;
	private JLabel currentPlayerLabel;
	private JPanel currentBalanceContainer;
	private JLabel currentBalanceHeader;
	private JLabel currentBalanceLabel;
	
	// PlayerActionDelegate
	private Player currentPlayer;
	
	{
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		this.createUIComponents();
		
		this.add(this.headerLabel);
		this.add(Box.createRigidArea(new Dimension(0,50)));
		this.add(this.currentPlayerContainer);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(this.currentBalanceContainer);
		this.add(Box.createVerticalGlue());
		this.add(this.diceButton);
	}
	
	private void createUIComponents() {
		
		// header label
		this.headerLabel = new JLabel("Monopoly");
		this.headerLabel.setFont(new Font("Serif", Font.BOLD, 48));
		this.headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// current player label
		this.currentPlayerContainer = new JPanel();
		this.currentPlayerContainer.setLayout(new BoxLayout(this.currentPlayerContainer, BoxLayout.LINE_AXIS));
		this.currentPlayerContainer.setBackground(new Color(102,102,102));
		this.currentPlayerHeader = new JLabel("Aktueller Spieler: ");
		this.currentPlayerLabel = new JLabel("test");
		this.currentPlayerContainer.add(this.currentPlayerHeader);
		this.currentPlayerContainer.add(Box.createHorizontalGlue());
		this.currentPlayerContainer.add(this.currentPlayerLabel);
		this.currentPlayerContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// current player's balance label
		this.currentBalanceContainer = new JPanel();
		this.currentBalanceContainer.setLayout(new BoxLayout(this.currentBalanceContainer, BoxLayout.LINE_AXIS));
		this.currentBalanceContainer.setBackground(new Color(102,102,102));
		this.currentBalanceHeader = new JLabel("Kontostand: ");
		this.currentBalanceLabel = new JLabel("test");
		this.currentBalanceContainer.add(this.currentBalanceHeader);
		this.currentBalanceContainer.add(Box.createHorizontalGlue());
		this.currentBalanceContainer.add(this.currentBalanceLabel);
		this.currentBalanceContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// dice button
		this.diceButton = new JButton();
		this.diceButton.setText("Dice");
		this.diceButton.setBounds(0, 0, 100, 50);
		this.diceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.diceButton.setEnabled(false);
		this.diceButton.addActionListener(this);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	// PLAYER ACTION DELEGATE
	
	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
		this.currentPlayerLabel.setText(this.currentPlayer.getName());
		this.currentBalanceLabel.setText(this.currentPlayer.getBalance() + " EUR");
	}
	
	@Override
	public void playerShouldRollDice() {
		// show 'roll dice' button
		this.diceButton.setEnabled(true);
	}
	
	public void playerDidRollDice() {
		// hide the dice button
		this.diceButton.setEnabled(false);
		
		// actually roll the dice
		DiceRoll diceRoll = this.game.getDice().roll();
		
		// TODO : show dice value(s)
		System.out.println("Dice : " + diceRoll.getFirstDice() + ", " + diceRoll.getSecondDice());
		
		if (null != this.currentPlayer) {
			this.currentPlayer.getActionImplementor().playerDidRollDice(diceRoll);
		}
	}
	
	// ACTION LISTENER
	
	public void actionPerformed(ActionEvent e) {
        if (this.diceButton == e.getSource()) {

        	Runnable doWorkRunnable = new Runnable() {
    		    public void run() { playerDidRollDice(); }
    		};
    		
    		//SwingUtilities.invokeLater(doWorkRunnable);
    		new Thread(doWorkRunnable).start();
        }
    }
}
