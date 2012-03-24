/**
	EducationalMonopoly
	SwingGameRepresentation.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.gameRepresentation;

import javax.swing.JFrame;

/**
 * @author benjamin
 *
 */
public class SwingGameRepresentation implements IGameRepresentation {

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
	}

}

