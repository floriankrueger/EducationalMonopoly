/**
	EducationalMonopoly
	PlayerActionPanel.java
	08.04.2012
*/

package de.dhbw.educationalmonopoly.gameRepresentation.swingUI;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayerActionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public PlayerActionPanel() {
		JButton diceButton = new JButton();
		diceButton.setText("Dice");
		diceButton.setBounds(0, 0, 100, 50);
		this.add(diceButton);
	}
}
