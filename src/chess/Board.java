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
	private boolean turnStatus; //true for white, false for black
	private int selectedRow;
	private int selectedCol;
	private MoveData[] selectedMoves;
	private Piece selectedPiece;
	
	/**
	 * Constructor that sets up layout and initializes
	 * the boardState array of the chess board.
	 */
	public Board() {
		setLayout(null);
		setOpaque(true);
		addMouseListener(this);
		setupBoard();
	} //end constructor
	
	public boolean getTurn() {
		return turnStatus;
	}
	
	public static Piece getSquare(int row, int col) {
		return boardState[row][col];
	}
	
	/**
	 * Initializes boardState array with each piece 
	 * in the correct position for a standard chess game.
	 * Also resets turn status and selected things.
	 * 
	 */
	public void setupBoard() {
		/*
		 * Initialize game data.
		 */
		turnStatus = true;
		selectedRow = -1;
		selectedCol = -1;
		selectedMoves = null;
		selectedPiece = null;
		
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
	} //end setupBoard
	
	/**
	 * Moves a piece from one square to another, as
	 * governed by the MoveData object parameter. Then resets
	 * selections and switches turns.
	 * @param move the move to be executed
	 */
	public void makeMove(MoveData move) {
		Piece movingPiece = move.getPiece();
		boardState[move.getStartRow()][move.getStartCol()] = null;
		boardState[move.getEndRow()][move.getEndCol()] = movingPiece;
		movingPiece.setRow(move.getEndRow());
		movingPiece.setCol(move.getEndCol());
		if (movingPiece instanceof Pawn) {
			Pawn movedPawn = (Pawn)movingPiece;
			movedPawn.setMoved();
		}
		selectedMoves = null;
		selectedRow = -1;
		selectedCol = -1;
		turnStatus = !turnStatus;
		//putPieces();
		repaint();
	} //end makeMove
	
	/**
	 * Paints the chess board: border and squares.
	 */
	public void paintComponent(Graphics paint) {
		paint.setColor(Color.BLACK);
		paint.drawRect(0, 0, 451, 451);
		paint.drawRect(1, 1, 449, 449);		//Draws 2px wide border around edge of board
		
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Color bgColor;
				if ((row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1)) {
					//paint.setColor(Color.WHITE);
					bgColor = Color.WHITE;
				}
				else { 
					//paint.setColor(Color.GRAY);
					bgColor = Color.GRAY;
				}
				Piece currentPiece = boardState[row][col];
				try {
					if (currentPiece == null)
						chessImage = ImageIO.read(new File("PieceImages/Chess/EmptyIcon.png"));
					else
						chessImage = ImageIO.read(new File(currentPiece.getPath(currentPiece.getColor())));
				} catch (IOException e) {
					e.printStackTrace();
				}
				//paint.fillRect(2 + (56 * col), 2 + (56 * row), 56, 56);
				paint.drawImage(chessImage, 2 + (56 * row), 2 + (56 * col), bgColor, this);
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
					if ((turnStatus && currentPiece.getColor()) || (!turnStatus && !currentPiece.getColor())) {
						paint.setColor(Color.GREEN);
						MoveData[] moveArray = currentPiece.getLegalMoves();
						if (moveArray != null && moveArray.length != 0) {
							paint.drawRect(2 + (56 * row), 2 + (56 * col), 56, 56);
							paint.drawRect(3 + (56 * row), 3 + (56 * col), 54, 54);
						}
					}
				}
			}
		}
		
		
		/*
		 * After a click: 
		 * highlight the square of the selected piece in orange, 
		 * each legal move in blue, and each capture in red.
		 */
		if (selectedRow > -1) {
			if ((turnStatus && selectedPiece.getColor()) || (!turnStatus && !selectedPiece.getColor())) {
				paint.setColor(Color.ORANGE);
				paint.drawRect(2 + (56 * selectedRow), 2 + (56 * selectedCol), 56, 56);
				paint.drawRect(3 + (56 * selectedRow), 3 + (56 * selectedCol), 54, 54);
				
				for (MoveData move : selectedMoves) {
					if (move.checkCapture())
						paint.setColor(Color.RED);
					else
						paint.setColor(Color.BLUE);
					paint.drawRect(2 + (56 * move.getEndRow()), 2 + (56 * move.getEndCol()), 56, 56);
					paint.drawRect(3 + (56 * move.getEndRow()), 3 + (56 * move.getEndCol()), 54, 54);
				}
			}
		}
	} //end paintComponent
	
	/**
	 * Changes the selected piece to the piece in the
	 * square that was clicked on and repaints the board
	 * accordingly.
	 */
	public void mousePressed(MouseEvent mEvt) {
		selectedRow = (mEvt.getX() - 2) / 56;
		selectedCol = (mEvt.getY() - 2) / 56 ;
		selectedPiece = boardState[selectedRow][selectedCol];
		if (selectedMoves != null) {
			for (MoveData move : selectedMoves) {
				if (selectedRow == move.getEndRow() && selectedCol == move.getEndCol()) {
					makeMove(move);
					break;
				}
			}
		}
		if (selectedPiece == null) {
			System.out.println(selectedRow + "," + selectedCol);
			selectedMoves = null;
			selectedCol = -1; //So pieces with legal moves will still be highlighted
			selectedRow = -1;
		}
		else {
			selectedMoves = selectedPiece.getLegalMoves();
			System.out.println(selectedPiece.getClass() + ": " + selectedRow + "," + selectedCol);
		}
		repaint();
	}
	
	public void mouseEntered(MouseEvent mEvt) {}
	public void mouseExited(MouseEvent mEvt) {}
	public void mouseReleased(MouseEvent mEvt) {}
	public void mouseClicked(MouseEvent mEvt) {}
} //end class Board
