package de.dhbw.educationalmonopoly.model.field;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Field {
	
	private String name;
	
	public Field(String name) {
		this.setName(name);
	}
	
	public void draw(Graphics2D g2d, Rectangle drawFrame) {
		// TODO: implement drawing
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
