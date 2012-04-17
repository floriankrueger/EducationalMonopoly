package de.dhbw.educationalmonopoly.model;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import de.dhbw.educationalmonopoly.model.Game.MonopolyType;
import de.dhbw.educationalmonopoly.model.field.Field;

public class GameFactory {

	public static Game createGameWithType(MonopolyType monopolyType) {
		Game aGame = new Game(monopolyType);	

		String fileName;
		int initialBankBalance;
		Dice dice;

		switch (monopolyType) {
		case CLASSIC:
		default:
			fileName = "classic.xml";
			initialBankBalance = 200000;
			dice = new Dice();
			break;
		}

		// create game board
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = null;
		
		try {
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException pce) {
			System.out.println(pce.getLocalizedMessage());
		} catch (SAXException se) {
			System.out.println(se.getLocalizedMessage());
		}
		
		GameFactorySAXHandler handler = new GameFactorySAXHandler();

		try {
			saxParser.parse(fileName, handler);
		} catch (IOException ioe) {
			System.out.println(ioe.getLocalizedMessage());
		} catch (SAXException se) {
			System.out.println(se.getLocalizedMessage());
		}
		
		List<Field> fields = handler.getFields();
		GameBoard aBoard = new GameBoard(fields);
		aGame.setGameBoard(aBoard);
		
		// set Dice
		aGame.setDice(dice);
		
		// create bank
		Bank bank = new Bank(initialBankBalance);
		aGame.setBank(bank);
		
		return aGame;
	}
	
}
