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

public class LocalPlayerActionImplementor implements PlayerActionImplementor {
	
	private Game game;
	private Player player;
	private List<PlayerActionListener> observers;

	{
		this.observers = new ArrayList<PlayerActionListener>();
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
	public void playerDidRollDice(DiceRoll diceRoll) {
		for (PlayerActionListener listener : this.observers) {
			listener.playerDidRollDice(this.player, diceRoll);
		}
	}

	@Override
	public void addPlayerActionListener(PlayerActionListener listener) {
		this.observers.add(listener);
	}

	@Override
	public void removePlayerActionListener(PlayerActionListener listener) {
		this.observers.remove(listener);
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}
}
