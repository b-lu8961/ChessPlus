package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel {
	private static final long serialVersionUID = 3L;
	
	public Board() {
		setOpaque(false);
	}
	
	/**
	 * Paints the chess board.
	 */
	public void paintComponent(Graphics paint) {
		paint.setColor(Color.BLACK);
		paint.drawRect(0, 0, 451, 451);
		paint.drawRect(1, 1, 449, 449);		//Draws 2px wide border
		
		for (int row = 1; row <= 8; row++) {
			for (int col = 1; col <= 8; col++) {
				if ((row % 2 == 1 && col % 2 == 1) || (row % 2 == 0 && col % 2 == 0))
					paint.setColor(Color.LIGHT_GRAY);
				else 
					paint.setColor(Color.BLACK);
				paint.fillRect(2 + (56 *(col - 1)), 2 + (56 *(row - 1)), 56, 56);
			}
		}
		
	}
}
