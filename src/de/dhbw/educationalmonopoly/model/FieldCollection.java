package de.dhbw.educationalmonopoly.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import de.dhbw.educationalmonopoly.model.field.CollectableField;
import de.dhbw.educationalmonopoly.model.field.IBuyable;

public class FieldCollection {
	
	private List<CollectableField> fields;
	private Color color;
	
	public FieldCollection() {
		this.fields = new ArrayList<CollectableField>();
	}
	
	public List<CollectableField> getFields() {
		return this.fields;
	}
	
	public void addField(CollectableField field) {
		this.fields.add(field);
	}
	
	public void removeField(IBuyable field) {
		this.fields.remove(field);
	}
	
	public void setColor(int red, int green, int blue) {
		this.color = new Color(red, green, blue);
	}
	
	public Color getColor() {
		return this.color;
	}
}
