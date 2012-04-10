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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerActionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// UI Components
	private JLabel headerLabel;
	private JButton diceButton;
	private JPanel currentPlayerContainer;
	private JLabel currentPlayerHeader;
	private JLabel currentPlayerLabel;
	
	public PlayerActionPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		this.createUIComponents();
		
		this.add(this.headerLabel);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(this.currentPlayerContainer);
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
		
		// dice button
		this.diceButton = new JButton();
		this.diceButton.setText("Dice");
		this.diceButton.setBounds(0, 0, 100, 50);
		this.diceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
}
