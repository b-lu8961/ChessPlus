package chess;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import chess.pieces.*;

public class Board extends JPanel implements MouseListener {
	private static final long serialVersionUID = 3L;
	
	private BufferedImage chessImage;
	private static Piece[][] boardState = new Piece[8][8];
	private boolean turnStatus = true; //true for white, false for black
	private int selectedRow = -1;
	private int selectedCol = -1;
	
	/**
	 * Constructor that sets up layout and initializes
	 * the boardState array of the chess board.
	 */
	public Board() {
		setLayout(null);
		setOpaque(true);
		addMouseListener(this);
		boardState = setupBoard();
	} //end constructor
	
	public static Piece getSquare(int row, int col) {
		return boardState[row][col];
	}
	
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
						boardState[j][i] = new Pawn(j, i, false);
					else if (i == 6)
						boardState[j][i] = new Pawn(j, i, true);
					else 
						boardState[j][i] = null;
			}
		}
		
		/*
		 * Initialize other black pieces
		 */
		for (int j = 0; j < boardState[0].length; j++) {
			if (j == 0 || j == 7)
				boardState[j][0] = new Rook(j, 0, false);
			else if (j == 1 || j == 6) 
				boardState[j][0] = new Knight(j, 0, false);
			else if (j == 2 || j == 5)
				boardState[j][0] = new Bishop(j, 0, false);
			else if (j == 3)
				boardState[j][0] = new Queen(j, 0, false);
			else
				boardState[j][0] = new King(j, 0, false);
		}
		
		/*
		 * Initialize other white pieces
		 */
		for (int j = 0; j < boardState[0].length; j++) {
			if (j == 0 || j == 7)
				boardState[j][7] = new Rook(j, 7, true);
			else if (j == 1 || j == 6) 
				boardState[j][7] = new Knight(j, 7, true);
			else if (j == 2 || j == 5)
				boardState[j][7] = new Bishop(j, 7, true);
			else if (j == 3)
				boardState[j][7] = new Queen(j, 7, true);
			else
				boardState[j][7] = new King(j, 7, true);
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
					pieceIcon.setBounds(5 + (56 * row), 5 + (56 * col), 50, 50);
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
		
		/*
		 * Highlight the square of each piece that has 
		 * a possible move in green.
		 */
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Piece currentPiece = boardState[row][col];
				if (currentPiece != null) {
					if (turnStatus && currentPiece.getColor() && selectedRow == -1) {
						paint.setColor(Color.GREEN);
						MoveData[] moveArray = currentPiece.getLegalMoves();
						if (moveArray != null) {
							paint.drawRect(2 + (56 * row), 2 + (56 * col), 56, 56);
							paint.drawRect(3 + (56 * row), 3 + (56 * col), 54, 54);
						}
					}
				}
			}
		}
		
		/*
		 * After a click: 
		 * highlight the square of the selected piece in green, 
		 * each legal move in blue, and each capture in red.
		 */
		if (selectedRow > -1) {
			Piece selectedPiece = boardState[selectedRow][selectedCol];
			if (selectedPiece != null && (turnStatus && selectedPiece.getColor())) {
				paint.setColor(Color.GREEN);
				paint.drawRect(2 + (56 * selectedRow), 2 + (56 * selectedCol), 56, 56);
				paint.drawRect(3 + (56 * selectedRow), 3 + (56 * selectedCol), 54, 54);
				paint.setColor(Color.BLUE);
				MoveData[] moveArray = selectedPiece.getLegalMoves();
				for (MoveData move : moveArray) {
					paint.drawRect(2 + (56 * move.getRow()), 2 + (56 * move.getCol()), 56, 56);
					paint.drawRect(3 + (56 * move.getRow()), 3 + (56 * move.getCol()), 54, 54);
				}
			}
		}
	} //end paintComponent
	
	public void mousePressed(MouseEvent mEvt) {
		selectedRow = (mEvt.getX() - 2) / 56;
		selectedCol = (mEvt.getY() - 2) / 56 ;
		System.out.println(boardState[selectedRow][selectedCol].getPath(true) + ": " + selectedRow + "," + selectedCol);
		repaint();
	}
	
	public void mouseEntered(MouseEvent mEvt) {}
	public void mouseExited(MouseEvent mEvt) {}
	public void mouseReleased(MouseEvent mEvt) {}
	public void mouseClicked(MouseEvent mEvt) {}
} //end class Board
