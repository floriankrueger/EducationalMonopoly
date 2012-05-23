package de.dhbw.educationalmonopoly.model.field;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public abstract class Field {
	
	public enum DrawOrientation {
		NORTH,
		SOUTH,
		EAST,
		WEST
	}
	
	private String name;
	private DrawOrientation drawOrientation;
	private AffineTransform transform;
	// if needed this member stores the drawing position of the field
	private Rectangle drawingRectangle;
	
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
	
	public DrawOrientation getDrawOrientation() {
		return drawOrientation;
	}

	public void setDrawOrientation(DrawOrientation drawOrientation) {
		this.drawOrientation = drawOrientation;
	}

	public Rectangle getDrawingRectangle() {
		return drawingRectangle;
	}

	public void setDrawingRectangle(Rectangle drawingRectangle) {
		this.drawingRectangle = drawingRectangle;
	}

	public AffineTransform getTransform() {
		return transform;
	}

	public void setTransform(AffineTransform transform) {
		this.transform = transform;
	}
	
}
