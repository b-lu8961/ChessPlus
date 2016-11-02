package chess.pieces;

import chess.MoveData;

public abstract class Piece {
	private String whitePath;
	private String blackPath;
	private boolean isWhite;
	protected int row;
	private int col;
	
	/**
	 * Constructor that initializes the color and file paths for
	 * each chess piece.
	 * @param whitePath file path for white version of piece
	 * @param blackPath file path for black version of piece
	 * @param isWhite   the color of the piece (black or white)   
	 */
	public Piece(String whitePath, String blackPath, int row, int col, boolean isWhite) {
		this.whitePath = whitePath;
		this.blackPath = blackPath;
		this.row = row;
		this.col = col;
		this.isWhite = isWhite;
	}
	
	public void setRow(int newRow) {
		row = newRow;
	}
	
	public void setCol(int newCol) {
		col = newCol;
	}
	
	/**
	 * Gets the row of the board that the piece is on.
	 * @return the current row of the piece
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Gets the column of the board that the piece is on.
	 * @return the current column of the piece
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * Getter method to find the color of a piece. True is white 
	 * and false is black.
	 * @return the color of the piece as a boolean
	 */
	public boolean getColor() {
		return isWhite;
	}
	
	/**
	 * Gets the image file path for the piece.
	 * @param isWhite the color of the piece (black or white)
	 * @return the file path for the image of the piece
	 */
	public String getPath(boolean isWhite) {
		if (isWhite)
			return whitePath;
		else
			return blackPath;
	}
	
	public abstract MoveData[] getLegalMoves();
}
