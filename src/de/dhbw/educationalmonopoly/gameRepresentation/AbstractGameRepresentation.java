/**
	EducationalMonopoly
	AbstractGameRepresentation.java
	23.05.2012
*/

package de.dhbw.educationalmonopoly.gameRepresentation;

import de.dhbw.educationalmonopoly.model.Game;
import de.dhbw.educationalmonopoly.model.Token;

public abstract class AbstractGameRepresentation implements IGameRepresentation {
	
	protected Game game;

	public void moveTokenToFieldIndexAnimated(Token token, int fieldIndex, boolean animated) {
		this.game.tokenMovementCompleted();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
}
