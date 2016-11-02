package chess.pieces;

import chess.MoveData;

public class Bishop extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteBishop.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackBishop.png";
	
	public Bishop(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	
	public MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
