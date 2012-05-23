/**
	EducationalMonopoly
	Main.java
	24.03.2012
*/
package de.dhbw.educationalmonopoly.core;

import de.dhbw.educationalmonopoly.gameRepresentation.ConsoleGameRepresentation;
import de.dhbw.educationalmonopoly.gameRepresentation.IGameRepresentation;
import de.dhbw.educationalmonopoly.model.Building;
import de.dhbw.educationalmonopoly.model.FieldCollection;
import de.dhbw.educationalmonopoly.model.Game;
import de.dhbw.educationalmonopoly.model.Hotel;
import de.dhbw.educationalmonopoly.model.House;
import de.dhbw.educationalmonopoly.model.Player;
import de.dhbw.educationalmonopoly.model.Game.MonopolyType;
import de.dhbw.educationalmonopoly.model.GameFactory;
import de.dhbw.educationalmonopoly.model.field.Field;
import de.dhbw.educationalmonopoly.model.field.IBuyable;
import de.dhbw.educationalmonopoly.model.field.StreetField;

/**
 * @author fkrueger
 *
 */
public class Main {

	private static Game game;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create game
		System.out.println("Starting LE-Edition");
		game = GameFactory.createGameWithType(MonopolyType.CLASSIC);
		
		// create ui representation
		IGameRepresentation gameRepresentation = new ConsoleGameRepresentation();
		game.setGameRepresenation(gameRepresentation);
		
		// create two players
		game.addNewLocalPlayer("Bugs Bunny");
		game.addNewLocalPlayer("Duffy Duck");
				
		// start the game
		game.start();
		
		buyFieldAtFieldIndex(9);
		game.endTurn();
		buyFieldAtFieldIndex(3);
		buyFieldAtFieldIndex(1);
		buildHouseAtFieldIndex(3);
		buildHouseAtFieldIndex(3);
		showFieldAtFieldIndex(3);
		showFieldAtFieldIndex(1);
		showFieldAtFieldIndex(9);
		
		System.out.println("--");
		
		game.getGameRepresenation().drawField();
	}
	
	public static void movePlayerToFieldIndex(int fieldIndex) {
		game.getPlayerOnTurn().getToken().setFieldIndex(fieldIndex);
	}
	
	public static Field getCurrentField() {
		return game.getGameBoard().getFields().get(game.getPlayerOnTurn().getToken().getFieldIndex());
	}
	
	public static void buyFieldAtFieldIndex(int fieldIndex) {
		movePlayerToFieldIndex(fieldIndex);
		Field currentField = getCurrentField();
		
		if (currentField instanceof IBuyable) {
			// cast the field
			IBuyable myField = (IBuyable) currentField;
			if (myField.hasOwner()) {
				//TODO: charge fee if houses or hotels exist
			} else {
				//TODO: offer player to buy street
				myField.buy(game.getPlayerOnTurn());
				System.out.println(game.getPlayerOnTurn().getName()+" purchased "+currentField.getName());
			}
		}
	}
	
	public static void buildHouseAtFieldIndex(int fieldIndex) {
		if (canPlayerBuildHouseAtFieldIndex(game.getPlayerOnTurn(), fieldIndex)) {
			attemptToBuildHouseAtFieldIndex(game.getPlayerOnTurn(), fieldIndex);
		} else {
			System.out.println("Player cant build house on current field. Aint the owner of all collectables.");
		}
	}
	
	
	/* BELONGS TO GAME */
	
	public static boolean canPlayerBuildHouseAtFieldIndex(Player player, int fieldIndex) {
		boolean canBuild = true;
		Field currentField = game.getGameBoard().getFields().get(fieldIndex);
		
		if (currentField instanceof StreetField) {
			FieldCollection affectedFieldCollection = ((StreetField) currentField).getFieldCollection();
			
			for (Field field: affectedFieldCollection.getFields()) {
				if (field instanceof StreetField) {
					// TODO: implement equals for player
					canBuild = canBuild && (((StreetField)field).getOwner() == player);
				} else {
					canBuild = false;
				}
			}
			
		} else {
			canBuild = false;
		}
		
		return canBuild;
	}
	
	public static void attemptToBuildHouseAtFieldIndex(Player player, int fieldIndex) {
		if (canPlayerBuildHouseAtFieldIndex(player, fieldIndex)) {
			House house = new House();
			Field currentField = game.getGameBoard().getFields().get(fieldIndex);
			((StreetField)currentField).addBuilding(house);
		}
	}
	
	public static void showFieldAtFieldIndex(int fieldIndex) {
		Field currentField = game.getGameBoard().getFields().get(fieldIndex);
		if (currentField instanceof StreetField) {
			StreetField streetField = ((StreetField) currentField);
			System.out.println("Street Name:"+streetField.getName());
			System.out.println("Owner: "+streetField.getOwner().getName());
			System.out.println("Buildings: ");
			
			int currentRent = 100;
			
			for (Building building : streetField.getBuildings()) {
				if (building instanceof House) {
					System.out.println("- a nice House");
					currentRent += 200;
				} else if (building instanceof Hotel) {
					System.out.println("- a nice Hotel");
					currentRent += 1000;
				}
			}
			
			System.out.println("Current Rent: "+currentRent);
		}
	}

}
