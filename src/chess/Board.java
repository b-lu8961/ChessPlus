package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 2L;
	
	private int[][] boardState = new int[8][8];
	private JButton resignButton;
	private JButton newGameButton;
	private JLabel chessMessage;
	
	public Board() {
		/*setBounds(20, 20, 450, 450);
		setBackground(Color.GRAY);
		boardState = setupData();*/
		
	}
	
	/**
	 * Adds the chess board and associated 
	 * buttons to main window.
	 */
	public void showChessBoard() {
		resignButton = new JButton("Resign");
		resignButton.setBounds(590, 100, 100, 30);
		
		newGameButton = new JButton("New game");
		newGameButton.setBounds(590, 60, 100, 30);
		
		chessMessage = new JLabel("Please work");
		
		add(resignButton);
		add(newGameButton);
		add(chessMessage);
		//add(this);
		validate();
		repaint();
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
