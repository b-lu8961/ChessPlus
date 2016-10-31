package chess.pieces;

import chess.MoveData;

public class Knight extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteKnight.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackKnight.png";
	
	public Knight(boolean isWhite) {
		super(whitePath, blackPath, isWhite);
	}
	
	@Override
	MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
