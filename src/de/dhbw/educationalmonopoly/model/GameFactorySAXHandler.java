package de.dhbw.educationalmonopoly.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.dhbw.educationalmonopoly.model.field.ChanceField;
import de.dhbw.educationalmonopoly.model.field.CollectableField;
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

public class GameFactorySAXHandler extends DefaultHandler {
	
	boolean readCollections = false;
	boolean readFields = false;
	boolean readCollection = false;
	boolean readField = false;
	
	Map<String,FieldCollection> fieldCollections = new HashMap<String, FieldCollection>();
	List<Field> fields = new ArrayList<Field>();
	
	String currentCollectionName;
	String currentFieldKey;
	Map<String,String> currentFieldData;
	
	public List<Field> getFields() {
		return this.fields;
	}
	
	public void startElement(String uri, String localName,
			String qName, Attributes attributes) throws SAXException {
		
		// COLLECTIONS (START)
		if (qName.equalsIgnoreCase("collections")) {
			readCollections = true;
		} 
		
		// COLLECTIONS :: COLLECTION (START)
		else if (readCollections && qName.equalsIgnoreCase("collection")) {
			readCollection = true;
			
			// find current collection name
			currentCollectionName = attributes.getValue("name");
			
			// create new collection
			fieldCollections.put(currentCollectionName, new FieldCollection());
		}
		
		// COLLECTIONS :: COLLECTION :: COLOR (START)
		else if (readCollection && qName.equalsIgnoreCase("color")) {
			
			FieldCollection currentCollection = fieldCollections.get(currentCollectionName);
			
			int red = Integer.parseInt(attributes.getValue("red"));
			int green = Integer.parseInt(attributes.getValue("green"));
			int blue = Integer.parseInt(attributes.getValue("blue"));
			
			currentCollection.setColor(red, green, blue);
			
		}
		
		// FIELDS (START)
		else if (qName.equalsIgnoreCase("fields")) {
			readFields = true;
		} 
		
		// FIELDS :: FIELD (START)
		else if (readFields && qName.equalsIgnoreCase("field")) {
			readField = true;
			
			currentFieldData = new HashMap<String, String>();
			currentFieldData.put("class", attributes.getValue("class"));
		}
		
		// FIELDS :: FIELD :: <KEY> (START)
		else if (readFields) {
			currentFieldKey = qName;
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		// COLLECTIONS (END)
		if (readCollections && qName.equalsIgnoreCase("collections")) {
			readCollections = false;
		} 
		
		// COLLECTIONS :: COLLECTION (END)
		else if (readCollection && qName.equalsIgnoreCase("collection")) {
			readCollection = false;
			currentCollectionName = null;
		} 
		
		// FIELDS (END)
		else if (readFields && qName.equalsIgnoreCase("fields")) {
			readFields = false;
		} 
		
		// FIELDS :: FIELD (END)
		else if (readField && qName.equalsIgnoreCase("field")) {
			readField = false;
			
			Field currentField = null;
			
			// get class name
			String className = currentFieldData.get("class");
			
			// ChanceField
			if (className.equalsIgnoreCase("ChanceField")) {
				currentField = new ChanceField();
			}
			
			// CommunityChestField
			else if (className.equalsIgnoreCase("CommunityChestField")) {
				currentField = new CommunityChestField();
			}
			
			// FreeParkingField
			else if (className.equalsIgnoreCase("FreeParkingField")) {
				currentField = new FreeParkingField();
			}
			
			// TrainStationField
			else if (className.equalsIgnoreCase("TrainStationField")) {
				String name = currentFieldData.get("name");
				int price = Integer.parseInt(currentFieldData.get("price"));
				currentField = new TrainStationField(name,TrainStationField.TrainStationType.SOUTH,price);
			}
			
			// GoToJailField
			else if (className.equalsIgnoreCase("GoToJailField")) {
				currentField = new GoToJailField();
			}
			
			// JailField
			else if (className.equalsIgnoreCase("JailField")) {
				currentField = new JailField();
			}
			
			// StartField
			else if (className.equalsIgnoreCase("StartField")) {
				currentField = new StartField();
			} 
			
			// SupplyCompanyField 
			else if (className.equalsIgnoreCase("SupplyCompanyField")) {
				String name = currentFieldData.get("name");
				int price = Integer.parseInt(currentFieldData.get("price"));
				currentField = new SupplyCompanyField(name, price);
			}
			
			// TaxField
			else if (className.equalsIgnoreCase("TaxField")) {
				String name = currentFieldData.get("name");
				int tax = Integer.parseInt(currentFieldData.get("tax"));
				currentField = new TaxField(name, tax);
			}
			
			// StreetField
			else if (className.equalsIgnoreCase("StreetField")) {
				String name = currentFieldData.get("name");
				int price = Integer.parseInt(currentFieldData.get("price"));
				currentField = new StreetField(name, price);
			}
			
			// add field to list if successful
			if (currentField != null) {
				fields.add(currentField);
				
				// add field to its collection if it has any
				String currentCollectionName = currentFieldData.get("collection");
				if (null != currentCollectionName) {
					FieldCollection fieldCollection = fieldCollections.get(currentCollectionName);
					
					if (null != fieldCollection) {
						fieldCollection.addField((CollectableField)currentField);
					}
				}
				
				currentField = null;
			}
		}
		
		// FIELDS :: FIELD :: <KEY> (END)
		else if (readFields) {
			currentFieldKey = null;
		}
	}

	public void characters(char ch[], int start, int length)
			throws SAXException {
		
		// FIELDS :: FIELD :: characters
		if (readField && (currentFieldKey != null)) {
			currentFieldData.put(currentFieldKey, new String(ch, start, length));
		}
	}
	
}
