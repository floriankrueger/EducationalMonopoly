/**
	EducationalMonopoly
	PlayerFactory.java
	Apr 16, 2012
*/

package de.dhbw.educationalmonopoly.model;

import de.dhbw.educationalmonopoly.core.LocalPlayerActionImplementor;
import de.dhbw.educationalmonopoly.core.PlayerActionImplementor;
import de.dhbw.educationalmonopoly.model.Game;

public class PlayerFactory {
	
	public static Player createLocalPlayer(Game game, String name) {
		
		int initialAccountBalance;
		
		switch (game.getMonopolyType()) {
		case CLASSIC:
		default:
			initialAccountBalance = 30000;
			break;
		}
		
		Player aPlayer = new Player(name, initialAccountBalance);
		
		PlayerActionImplementor actionImplementor = new LocalPlayerActionImplementor(game);
		aPlayer.setActionImplementor(actionImplementor);
		
		return aPlayer;
	}
	
}
