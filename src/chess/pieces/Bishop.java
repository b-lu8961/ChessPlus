package chess.pieces;

import chess.MoveData;

public class Bishop extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteBishop.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackBishop.png";
	
	public Bishop(boolean isWhite) {
		super(whitePath, blackPath, isWhite);
	}
	
	@Override
	MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
