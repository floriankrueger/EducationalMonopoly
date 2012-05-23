package de.dhbw.educationalmonopoly.gameRepresentation;

import java.util.List;

import de.dhbw.educationalmonopoly.model.Building;
import de.dhbw.educationalmonopoly.model.DiceRoll;
import de.dhbw.educationalmonopoly.model.Hotel;
import de.dhbw.educationalmonopoly.model.House;
import de.dhbw.educationalmonopoly.model.Player;
import de.dhbw.educationalmonopoly.model.field.ChanceField;
import de.dhbw.educationalmonopoly.model.field.CommunityChestField;
import de.dhbw.educationalmonopoly.model.field.Field;
import de.dhbw.educationalmonopoly.model.field.FreeParkingField;
import de.dhbw.educationalmonopoly.model.field.GoToJailField;
import de.dhbw.educationalmonopoly.model.field.JailField;
import de.dhbw.educationalmonopoly.model.field.StartField;
import de.dhbw.educationalmonopoly.model.field.StreetField;
import de.dhbw.educationalmonopoly.model.field.SupplyCompanyField;
import de.dhbw.educationalmonopoly.model.field.TaxField;
import de.dhbw.educationalmonopoly.model.field.TrainStationField;

public class ConsoleGameRepresentation extends AbstractGameRepresentation implements PlayerActionDelegate {

	@Override
	public void presentMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawField() {
		List<Field> fields = this.game.getGameBoard().getFields();
		
		StringBuilder fieldIndexes = new StringBuilder("idx    ");
		StringBuilder fieldTypes = new StringBuilder(  "type   ");
		StringBuilder fieldHouses = new StringBuilder( "houses ");
		StringBuilder fieldHotels = new StringBuilder( "hotels ");
		
		// draw field
		int idx = 0;
		
		for (Field field : fields) {
			fieldIndexes.append(String.format("%4d ",idx));
			
			String type = null;
			
			if (field instanceof ChanceField) {
				type = "  CH ";
			} else if (field instanceof CommunityChestField) {
				type = "  CC ";
			} else if (field instanceof FreeParkingField) {
				type = "  FP ";
			} else if (field instanceof GoToJailField) {
				type = " GTJ ";
			} else if (field instanceof JailField) {
				type = "  JF ";
			} else if (field instanceof StartField) {
				type = "  SF ";
			} else if (field instanceof StreetField) {
				type = "   S ";
			} else if (field instanceof SupplyCompanyField) {
				type = " SCF ";
			} else if (field instanceof TaxField) {
				type = "  TF ";
			} else if (field instanceof TrainStationField) {
				type = " TSF ";
			} else {
				type = "   ? ";
			}
			
			fieldTypes.append(type);
			
			String houses = null;
			String hotels = null;
			
			if (field instanceof StreetField) {
				StreetField sf = (StreetField)field;
				
				int h1 = 0;
				int h2 = 0;
				
				for (Building b : sf.getBuildings()) {
					if (b instanceof House) {
						h1++; 
					} else if (b instanceof Hotel) {
						h2++;
					}
				}
				
				houses = String.format("%4d ", h1);
				hotels = String.format("%4d ", h2);
			} else {
				houses = "     ";
				hotels = "     ";
			}
			
			fieldHouses.append(houses);
			fieldHotels.append(hotels);
			
			idx++;
		}
		
		System.out.println();
		System.out.println(fieldIndexes.toString());
		System.out.println(fieldTypes.toString());
		System.out.println(fieldHouses.toString());
		System.out.println(fieldHotels.toString());
	}

	@Override
	public void setCurrentPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlayerActionDelegate getPlayerActionDelegate() {
		return this;
	}

	@Override
	public void displayDiceRoll(DiceRoll diceRoll) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerShouldRollDice() {
		// TODO Auto-generated method stub
		
	}

}