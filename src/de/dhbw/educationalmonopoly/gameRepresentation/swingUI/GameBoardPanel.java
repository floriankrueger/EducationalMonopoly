/**
	EducationalMonopoly
	GameFrame.java
	27.03.2012
*/

/**
 * 
 */
package de.dhbw.educationalmonopoly.gameRepresentation.swingUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JPanel;

import de.dhbw.educationalmonopoly.model.field.Field;
import de.dhbw.educationalmonopoly.model.field.StreetField;

/**
 * @author benjamin
 *
 */
public class GameBoardPanel extends JPanel {

	private List<Field> fields;
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) throws RuntimeException {
	      super.paintComponent(g);

	      Graphics2D g2d = (Graphics2D) g;

	      g2d.setColor(Color.blue);

	      Dimension size = getSize();
	      Insets insets = getInsets();

	      int w =  size.width - insets.left - insets.right;
	      int h =  size.height - insets.top - insets.bottom;
	      
	      int fields = this.fields.size();
	      
	      if ((fields % 4) != 0) {
		    	try {
					throw new Exception("Invalid Amount of Fields: amount of fields has to be dividable by four.");
				} catch (Exception e) {
					e.printStackTrace();
				} 
	      }
	      
	      int rowLength = fields / 4;

	      // setup initial positions
	      int currentX = w-100;
	      int currentY = h-100;
	      int fieldWidth = 60;
	      int fieldHeight = 60;
	      
	      drawGameField(g2d, rowLength, currentX, currentY, fieldWidth,
				fieldHeight);
	  }

	
	private void drawGameField(Graphics2D g2d, int rowLength, int currentX,
			int currentY, int fieldWidth, int fieldHeight) {
		
		  // initialize
		  int fieldIndex = 0;
		
		  // draw first row starting at the bottom right
	      for (int i=0; i<rowLength; i++) {
	    	  Rectangle rect = new Rectangle(currentX, currentY, fieldWidth, fieldHeight);
	    	  Field currentField = this.fields.get(fieldIndex);
	    	  this.drawField(currentField, g2d, rect);
	    	  currentX -= fieldWidth;
	          fieldIndex++;
	      } 
	      
	      // draw second row moving upwards
	      for (int i=0; i<rowLength; i++) {
	    	  Rectangle rect = new Rectangle(currentX, currentY, fieldWidth, fieldHeight);
	    	  Field currentField = this.fields.get(fieldIndex);
	    	  this.drawField(currentField, g2d, rect);
	    	  currentY -= fieldHeight;
	          fieldIndex++;    	  
	      }
	      
	      // draw third row moving right
	      for (int i=0; i<rowLength; i++) {
	    	  Rectangle rect = new Rectangle(currentX, currentY, fieldWidth, fieldHeight);
	    	  Field currentField = this.fields.get(fieldIndex);
	    	  this.drawField(currentField, g2d, rect);
	    	  currentX += fieldWidth;
	          fieldIndex++;   	    	  
	      }
	      
	      // draw fourth row moving downwards
      
	      for (int i=0; i<rowLength; i++) {
	    	  Rectangle rect = new Rectangle(currentX, currentY, fieldWidth, fieldHeight);
	    	  Field currentField = this.fields.get(fieldIndex);
	    	  this.drawField(currentField, g2d, rect);
	    	  currentY += fieldHeight;
	          fieldIndex++; 
	      }
	}
	
	private void drawField(final Field field, final Graphics2D g2d, Rectangle rect) {
		if (field instanceof StreetField) {
			g2d.setColor( ((StreetField)field).getColor() );
			System.out.println("");
			g2d.fillRect(rect.x, rect.y, rect.width, rect.height);
		} else {
			g2d.drawRect(rect.x, rect.y, rect.width, rect.height); 
		}
	}


	public List<Field> getFields() {
		return fields;
	}


	public void setFields(List<Field> fields) {
		this.fields = fields;
	} 
}
