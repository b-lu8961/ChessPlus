package chess.pieces;

import chess.MoveData;

public class Rook extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteRook.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackRook.png";
	
	public Rook(boolean isWhite) {
		super(whitePath, blackPath, isWhite);
	}
	
	@Override
	MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
