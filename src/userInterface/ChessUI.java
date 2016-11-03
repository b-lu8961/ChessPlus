package userInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessUI extends JPanel implements ActionListener {
	private static final long serialVersionUID = 2L;
	
	private JButton resignButton;
	private JButton newGameButton;
	private JLabel chessMessage;
	private chess.Board chessBoard;
	
	/**
	 * Constructor that creates the chess panel 
	 * and its associated components. Adds these 
	 * components to the panel.
	 */
	public ChessUI() {
		setLayout(null);
		setPreferredSize(new Dimension(700, 600));
		setBounds(0, 50, 700, 600);
		setOpaque(false);
		
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
		
		chessBoard = new chess.Board();
		chessBoard.setBounds(20, 20, 452, 452);
		
		add(chessBoard);
		add(resignButton);
		add(newGameButton);
		add(chessMessage);
	} //end constructor
	
	/**
	 * Perform actions on button presses
	 */
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		if (src == resignButton) {		//Need to implement turns
			if (chessBoard.getTurn())
				chessMessage.setText("White resigns. Black wins.");
			else
				chessMessage.setText("Black resigns. White wins.");
			chessBoard.setEnabled(false);
		}
		else if (src == newGameButton) {	//Resets chess board and starts new game
			chessMessage.setText("White: Make your move.");
			chessBoard.setupBoard();
			repaint();
		}
	}
	
} //class
