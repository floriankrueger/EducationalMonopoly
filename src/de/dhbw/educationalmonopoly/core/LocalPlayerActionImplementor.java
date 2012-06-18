/**
	EducationalMonopoly
	LocalPlayerActionImplementor.java
	Apr 16, 2012
*/

package de.dhbw.educationalmonopoly.core;

import java.util.ArrayList;
import java.util.List;

import de.dhbw.educationalmonopoly.model.DiceRoll;
import de.dhbw.educationalmonopoly.model.Game;
import de.dhbw.educationalmonopoly.model.Player;
import de.dhbw.educationalmonopoly.model.field.Field;

public class LocalPlayerActionImplementor implements IPlayerActionImplementor {
	
	private Game game;
	private Player player;
	private List<IPlayerActionListener> observers;

	{
		this.observers = new ArrayList<IPlayerActionListener>();
	}
	
	private LocalPlayerActionImplementor() {
		super();
	}
	
	public LocalPlayerActionImplementor(Game game) {
		this();
		this.game = game;
	}
	
	@Override
	public void rollDice() {
		this.game.getGameRepresenation().getPlayerActionDelegate().playerShouldRollDice();
	}
	
	@Override
	public void performFieldInteraction(Field field) {
		this.game.getGameRepresenation().getPlayerActionDelegate().playerShouldPerformFieldInteraction(field);
	}
	
	@Override
	public void playerDidPerformFieldInteraction() {
		for (int i=0; i < this.observers.size(); i++) {
			IPlayerActionListener listener = this.observers.get(i);
			listener.playerDidCompleteFieldInteraction();
		}
	}
	
	@Override
	public void playerDidRollDice(DiceRoll diceRoll) {
		for (int i=0; i < this.observers.size(); i++) {
			IPlayerActionListener listener = this.observers.get(i);
			listener.playerDidRollDice(this.player, diceRoll);
		}	
	}

	@Override
	public void addPlayerActionListener(IPlayerActionListener listener) {
		this.observers.add(listener);
	}

	@Override
	public void removePlayerActionListener(IPlayerActionListener listener) {
		this.observers.remove(listener);
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}
}
