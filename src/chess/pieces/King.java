package chess.pieces;

import chess.MoveData;

public class King extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteKing.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackKing.png";
	
	public King(boolean isWhite) {
		super(whitePath, blackPath, isWhite);
	}
	
	@Override
	MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
