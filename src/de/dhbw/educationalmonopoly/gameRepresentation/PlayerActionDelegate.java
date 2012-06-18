/**
	EducationalMonopoly
	PlayerActionDelegate.java
	Apr 17, 2012
*/

package de.dhbw.educationalmonopoly.gameRepresentation;

import de.dhbw.educationalmonopoly.model.field.Field;

public interface PlayerActionDelegate {
	
	/**
	 * Requests a dice roll from the current user.
	 */
	public void playerShouldRollDice();
	
	/**
	 * Requests a field interaction from the current user.
	 */
	public void playerShouldPerformFieldInteraction(Field field);
}
