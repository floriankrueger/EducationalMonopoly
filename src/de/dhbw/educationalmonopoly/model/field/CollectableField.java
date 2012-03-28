package de.dhbw.educationalmonopoly.model.field;

import java.awt.Color;

import de.dhbw.educationalmonopoly.model.FieldCollection;

public class CollectableField extends Field {

	private FieldCollection fieldCollection;
	
	public CollectableField(String name) {
		super(name);
	}
	
	public void setFieldCollection(FieldCollection fieldCollection) {
		this.fieldCollection = fieldCollection;
	}

	public FieldCollection getFieldCollection() {
		return this.fieldCollection;
	}
	
	public Color getColor() {
		Color aColor;
		
		if (null != this.fieldCollection) {
			aColor = this.fieldCollection.getColor();
		} else {
			aColor = null;
		}
		
		return aColor;
	}
	
}
