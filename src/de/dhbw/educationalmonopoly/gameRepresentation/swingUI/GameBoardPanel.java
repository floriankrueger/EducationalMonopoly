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
import java.util.List;

import javax.swing.JPanel;

import de.dhbw.educationalmonopoly.model.field.Field;

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
	      
	      System.out.println(this.fields.size());
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
		
		  // draw first row starting at the bottom right
	      g2d.fillRect(currentX, currentY, fieldWidth, fieldHeight);
          currentX -= fieldWidth;

	      for (int i=1; i<rowLength-1; i++) {
	          g2d.drawRect(currentX, currentY, fieldWidth, fieldHeight);
	          currentX -= fieldWidth;
	      } 
	      
	      // draw second row moving upwards
	      g2d.fillRect(currentX, currentY, fieldWidth, fieldHeight);
          currentY -= fieldHeight;	    	  

	      for (int i=1; i<rowLength-1; i++) {
	          g2d.drawRect(currentX, currentY, fieldWidth, fieldHeight);
	          currentY -= fieldHeight;	    	  
	      }
	      
	      // draw third row moving right
	      g2d.fillRect(currentX, currentY, fieldWidth, fieldHeight);
          currentX += fieldWidth;	    	  
	      
	      for (int i=1; i<rowLength-1; i++) {
	          g2d.drawRect(currentX, currentY, fieldWidth, fieldHeight);
	          currentX += fieldWidth;	    	  
	      }
	      
	      // draw fourth row moving downwards
	      g2d.fillRect(currentX, currentY, fieldWidth, fieldHeight);
          currentY += fieldHeight;
	      
	      for (int i=1; i<rowLength-1; i++) {
	          g2d.drawRect(currentX, currentY, fieldWidth, fieldHeight);
	          currentY += fieldHeight;
	      }
	}


	public List<Field> getFields() {
		return fields;
	}


	public void setFields(List<Field> fields) {
		this.fields = fields;
	} 
}
