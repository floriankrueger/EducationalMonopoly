/**
	EducationalMonopoly
	Token.java
	05.04.2012
*/

package de.dhbw.educationalmonopoly.model;

public class Token {

	// stores the tokens position on the field
	private int fieldIndex;

	{
		this.fieldIndex = 0;
	}
	
	public int getFieldIndex() {
		return fieldIndex;
	}

	public void setFieldIndex(int fieldIndex) {
		this.fieldIndex = fieldIndex;
	}
	
}
