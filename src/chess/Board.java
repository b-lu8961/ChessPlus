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
	
	
	/**
	 * Constructor that creates the chess panel 
	 * and its associated components. Adds these 
	 * components to the panel.
	 */
	public Board() {
		setLayout(null);
		setPreferredSize(new Dimension(700, 600));
		setBounds(0, 50, 700, 600);
		boardState = setupData();
		
		resignButton = new JButton("Resign");
		resignButton.setBounds(590, 50, 100, 30);
		resignButton.addActionListener(this);
		
		newGameButton = new JButton("New game");
		newGameButton.setBounds(590, 10, 100, 30);
		newGameButton.addActionListener(this);
		
		chessMessage = new JLabel("White: Make your move.");
		chessMessage.setBounds(120, 475, 400, 45);
		chessMessage.setOpaque(true);
		chessMessage.setBackground(new Color(242, 232, 172));
		chessMessage.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
		
		add(resignButton);
		add(newGameButton);
		add(chessMessage);
	} //end constructor
	
	public int[][] setupData() {
		for (int i = 0; i < boardState.length; i++) {
			for (int k = 0; k < boardState[0].length; k++) {
				
			}
		}
		return boardState;	
	}
	
	/**
	 * Paints the chess board.
	 */
	public void paintComponent(Graphics paint) {
		paint.setColor(Color.BLACK);
		paint.drawRect(20, 20, 450, 450);
		paint.drawRect(21, 21, 448, 448);		//Draws 2px wide border
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		if (src == resignButton) {
			chessMessage.setText("White/black has resigned. White/black wins.");
		}
		else if (src == newGameButton) {
			chessMessage.setText("White: Make your move.");
			chessMessage.repaint();
		}
	}
	public void mouseReleased(MouseEvent mEvt) {}
	public void mousePressed(MouseEvent mEvt) {}
	public void mouseClicked(MouseEvent mEvt) {}
	public void mouseEntered(MouseEvent mEvt) {}
	public void mouseExited(MouseEvent mEvt) {}
	
	
} //class
