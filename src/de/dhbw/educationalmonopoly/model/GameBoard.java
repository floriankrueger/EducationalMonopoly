package de.dhbw.educationalmonopoly.model;

import java.util.List;

import de.dhbw.educationalmonopoly.model.field.Field;

public class GameBoard {
	
	private List<Field> fields;

	public GameBoard(List<Field> fields) {
		this.fields = fields;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
}
