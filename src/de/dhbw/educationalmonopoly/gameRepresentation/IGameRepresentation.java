/**
	EducationalMonopoly
	IGameRepresentation.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.gameRepresentation;

/**
 * @author benjamin
 */
public interface IGameRepresentation {
	
	/**
	 * Does all necessary preparation to be able to draw
	 */
	public void initialize();
	
	/**
	 * Shows a menu from which a match can be started
	 */
	public void presentMenu();
	
	/**
	 * Draws the field in its current state
	 */
	public void drawField();

}
