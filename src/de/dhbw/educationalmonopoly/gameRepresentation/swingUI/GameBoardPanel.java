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
	      int fieldHeight = 80;
	      
	      drawGameField(g2d, rowLength, currentX, currentY, fieldWidth,
				fieldHeight);
	  }

	
	private void drawGameField(Graphics2D g2d, int rowLength, int currentX,
			int currentY, int fieldWidth, int fieldHeight) {
		
		  // initialize
		  int fieldIndex = 0;
		
		  // draw first row starting at the bottom right
    	  Rectangle rect = new Rectangle(currentX, currentY, fieldHeight, fieldHeight);
    	  Field currentField = this.fields.get(fieldIndex);
    	  currentField.setDrawOrientation(Field.DrawOrientation.NORTH);
    	  this.drawField(currentField, g2d, rect);
    	  currentX -= fieldWidth;
          fieldIndex++;
		  
	      for (int i=1; i<rowLength; i++) {
	    	  rect = new Rectangle(currentX, currentY, fieldWidth, fieldHeight);
	    	  currentField = this.fields.get(fieldIndex);
	    	  currentField.setDrawOrientation(Field.DrawOrientation.NORTH);
	    	  this.drawField(currentField, g2d, rect);
	    	  currentX -= fieldWidth;
	          fieldIndex++;
	      } 
	      
	      // increase distance for corner field
	      currentX -= (fieldHeight-fieldWidth);
	      
	      // draw second row moving upwards
    	  rect = new Rectangle(currentX, currentY, fieldHeight, fieldHeight);
    	  currentField = this.fields.get(fieldIndex);
    	  currentField.setDrawOrientation(Field.DrawOrientation.EAST);
    	  this.drawField(currentField, g2d, rect);
    	  currentY -= fieldWidth;
          fieldIndex++;
	      
	      for (int i=1; i<rowLength; i++) {
	    	  rect = new Rectangle(currentX, currentY,fieldHeight, fieldWidth);
	    	  currentField = this.fields.get(fieldIndex);
	    	  currentField.setDrawOrientation(Field.DrawOrientation.EAST);
	    	  this.drawField(currentField, g2d, rect);
	    	  currentY -= fieldWidth;
	          fieldIndex++;    	  
	      }
	      
	      // increase distance for corner field
	      currentY -= (fieldHeight-fieldWidth);
	      
	      // draw third row moving right
    	  rect = new Rectangle(currentX, currentY, fieldHeight, fieldHeight);
    	  currentField = this.fields.get(fieldIndex);
    	  currentField.setDrawOrientation(Field.DrawOrientation.SOUTH);
    	  this.drawField(currentField, g2d, rect);
    	  currentX += fieldHeight;
          fieldIndex++;   
	      
	      for (int i=1; i<rowLength; i++) {
	    	  rect = new Rectangle(currentX, currentY, fieldWidth, fieldHeight);
	    	  currentField = this.fields.get(fieldIndex);
	    	  currentField.setDrawOrientation(Field.DrawOrientation.SOUTH);
	    	  this.drawField(currentField, g2d, rect);
	    	  currentX += fieldWidth;
	          fieldIndex++;   	    	  
	      }
	      	      
	      // draw fourth row moving downwards
    	  rect = new Rectangle(currentX, currentY, fieldHeight, fieldHeight);
    	  currentField = this.fields.get(fieldIndex);
    	  currentField.setDrawOrientation(Field.DrawOrientation.WEST);
    	  this.drawField(currentField, g2d, rect);
    	  currentY += fieldHeight;
          fieldIndex++; 
	      
	      for (int i=1; i<rowLength; i++) {
	    	  rect = new Rectangle(currentX, currentY, fieldHeight, fieldWidth);
	    	  currentField = this.fields.get(fieldIndex);
	    	  currentField.setDrawOrientation(Field.DrawOrientation.WEST);
	    	  this.drawField(currentField, g2d, rect);
	    	  currentY += fieldWidth;
	          fieldIndex++; 
	      }
	}
	
	private void drawField(final Field field, final Graphics2D g2d, Rectangle rect) {
		// draw border
		g2d.setColor(new Color(0,0,0));
		g2d.drawRect(rect.x, rect.y, rect.width, rect.height); 
		
		// draw content
		if (field instanceof StreetField) {
			g2d.setColor( ((StreetField)field).getColor() );
			Rectangle fillRect = rect;
			
			switch (field.getDrawOrientation()) {
				case NORTH:
					fillRect.height = (int) (0.3*rect.height);
					break;
					
				case EAST:
					fillRect.x += (int) (0.7*rect.width);
					fillRect.width = (int) (0.3*rect.width);
					break;
					
				case SOUTH:
					fillRect.y += (int) (0.7*rect.height);
					fillRect.height = (int) (0.3*rect.height);
					break;
				
				case WEST:
					fillRect.width = (int) (0.3*rect.width);
					break;		
			}
			
			g2d.fillRect(fillRect.x, fillRect.y, fillRect.width, fillRect.height);
		}
	}


	public List<Field> getFields() {
		return fields;
	}


	public void setFields(List<Field> fields) {
		this.fields = fields;
	} 
}
