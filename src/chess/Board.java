package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import chess.pieces.*;

public class Board extends JPanel {
	private static final long serialVersionUID = 3L;
	
	private BufferedImage chessImage;
	private Piece[][] boardState = new Piece[8][8];
	
	/**
	 * Constructor that sets up layout and initializes
	 * the boardState array of the chess board.
	 */
	public Board() {
		setLayout(null);
		setOpaque(true);
		boardState = setupBoard();
	} //end constructor
	
	/**
	 * Initializes boardState array with the values
	 * of each piece in the correct position for a
	 * standard chess game.
	 * @return the boardState array initialized for a regular chess game	
	 */
	public Piece[][] setupBoard() {
		/*
		 * Initialize pawns
		 */
		for (int i = 1; i < boardState.length - 1; i++) {
			for (int j = 0; j < boardState[0].length; j++) {
					if (i == 1) 
						boardState[i][j] = new Pawn(false);
					else if (i == 6)
						boardState[i][j] = new Pawn(true);
					else 
						boardState[i][j] = null;
			}
		}
		
		/*
		 * Initialize other black pieces
		 */
		for (int j = 0; j < boardState[0].length; j++) {
			if (j == 0 || j == 7)
				boardState[0][j] = new Rook(false);
			else if (j == 1 || j == 6) 
				boardState[0][j] = new Knight(false);
			else if (j == 2 || j == 5)
				boardState[0][j] = new Bishop(false);
			else if (j == 3)
				boardState[0][j] = new Queen(false);
			else
				boardState[0][j] = new King(false);
		}
		
		/*
		 * Initialize other white pieces
		 */
		for (int j = 0; j < boardState[0].length; j++) {
			if (j == 0 || j == 7)
				boardState[7][j] = new Rook(true);
			else if (j == 1 || j == 6) 
				boardState[7][j] = new Knight(true);
			else if (j == 2 || j == 5)
				boardState[7][j] = new Bishop(true);
			else if (j == 3)
				boardState[7][j] = new Queen(true);
			else
				boardState[7][j] = new King(true);
		}
		return boardState;	
	} //end setupBoard
	
	/**
	 * Puts piece image in squares according 
	 * to value in the boardState array.
	 */
	public void putPieces() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (boardState[row][col] != null) {
					Piece currentPiece = boardState[row][col];
					try {
						chessImage = ImageIO.read(new File(currentPiece.getPath(currentPiece.getColor())));
					} catch (IOException e) {
						e.printStackTrace();
					}
					JLabel pieceIcon = new JLabel(new ImageIcon(chessImage));
					pieceIcon.setBounds(5 + (56 * col), 5 + (56 * row), 50, 50);
					add(pieceIcon);
				}
			}
		}
	} //end putPieces
	
	/**
	 * Paints the chess board: border and squares.
	 */
	public void paintComponent(Graphics paint) {
		paint.setColor(Color.BLACK);
		paint.drawRect(0, 0, 451, 451);
		paint.drawRect(1, 1, 449, 449);		//Draws 2px wide border around edge of board
		
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if ((row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1))
					paint.setColor(Color.WHITE);
				else 
					paint.setColor(Color.GRAY);
				paint.fillRect(2 + (56 * col), 2 + (56 * row), 56, 56);
			}
		}	
	} //end paintComponent
} //end class Board
