package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 2L;
	
	private int[][] boardState = new int[8][8];
	private JButton resignGame;
	private JButton newGame;
	private JLabel chessMessage;
	
	public Board() {
		setBackground(Color.GRAY);
		boardState = setupData();
		resignGame = new JButton("Resign");
		newGame = new JButton("New game");
	}
	
	public int[][] setupData() {
		for (int i = 0; i < boardState.length; i++) {
			for (int k = 0; k < boardState[0].length; k++) {
				
			}
		}
		return boardState;	
	}
	
	public void paintComponent(Graphics paint) {
		paint.setColor(Color.BLACK);
		paint.drawRect(20, 20, 450, 450);
		paint.drawRect(21, 21, 448, 448);
	}
	
	public void actionPerformed(ActionEvent evt) {}
	public void mouseReleased(MouseEvent mEvt) {}
	public void mousePressed(MouseEvent mEvt) {}
	public void mouseClicked(MouseEvent mEvt) {}
	public void mouseEntered(MouseEvent mEvt) {}
	public void mouseExited(MouseEvent mEvt) {}
	
} //class
