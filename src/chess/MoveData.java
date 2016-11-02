package chess;

import chess.pieces.Piece;

public class MoveData {
	private Piece startPiece;
	private int toRow;
	private int toCol;
	private int fromRow;
	private int fromCol;
	private boolean isACapture;
	
	public MoveData(Piece startPiece, int fromRow, int fromCol, int toRow, int toCol, boolean capture) {
		this.startPiece = startPiece;
		this.fromRow = fromRow;
		this.fromCol = fromCol;
		this.toRow = toRow;
		this.toCol = toCol;
		isACapture = capture;
	}
	
	public Piece getPiece() {
		return startPiece;
	}
	
	public int getStartRow() {
		return fromRow;
	}
	
	public int getStartCol() {
		return fromCol;
	}
	
	public int getEndRow() {
		return toRow;
	}
	
	public int getEndCol() {
		return toCol;
	}
	public boolean checkCapture() {
		return isACapture;
	}
}
