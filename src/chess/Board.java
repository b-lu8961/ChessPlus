package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import chess.Piece;

public class Board extends JPanel {
	private static final long serialVersionUID = 3L;
	
	private BufferedImage chessImage;
	private int[][] boardState = new int[8][8];
	
	public Board() {
		setLayout(null);
		setOpaque(true);
		boardState = setupBoard();
	}
	
	public int[][] setupBoard() {
		for (int i = 1; i < boardState.length - 1; i++) {
			for (int j = 0; j < boardState[0].length; j++) {
					if (i == 1) 
						boardState[i][j] = Piece.BLACK_PAWN.num();
					else if (i == 6)
						boardState[i][j] = Piece.WHITE_PAWN.num();
					else 
						boardState[i][j] = Piece.EMPTY.num();
			}
		}
		for (int j = 0; j < boardState[0].length; j++) {
			if (j == 0 || j == 7)
				boardState[0][j] = Piece.BLACK_ROOK.num();
			else if (j == 1 || j == 6) 
				boardState[0][j] = Piece.BLACK_KNIGHT.num();
			else if (j == 2 || j == 5)
				boardState[0][j] = Piece.BLACK_BISHOP.num();
			else if (j == 3)
				boardState[0][j] = Piece.BLACK_QUEEN.num();
			else
				boardState[0][j] = Piece.BLACK_KING.num();
		}
		for (int j = 0; j < boardState[0].length; j++) {
			if (j == 0 || j == 7)
				boardState[7][j] = Piece.WHITE_ROOK.num();
			else if (j == 1 || j == 6) 
				boardState[7][j] = Piece.WHITE_KNIGHT.num();
			else if (j == 2 || j == 5)
				boardState[7][j] = Piece.WHITE_BISHOP.num();
			else if (j == 3)
				boardState[7][j] = Piece.WHITE_QUEEN.num();
			else
				boardState[7][j] = Piece.WHITE_KING.num();
		}
		return boardState;	
	}
	
	/**
	 * Puts piece image in squares according to value in boardState
	 */
	public void putPieces() {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (boardState[row][col] != -1) {
					try {
						chessImage = ImageIO.read(new File(Piece.getPath(boardState[row][col])));
					} catch (IOException e) {
						e.printStackTrace();
					}
					JLabel pieceIcon = new JLabel(new ImageIcon(chessImage));
					pieceIcon.setBounds(5 + (56 * col), 5 + (56 * row), 50, 50);
					add(pieceIcon);
				}
			}
		}
	}
	
	/**
	 * Paints the chess board.
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
	}
}
