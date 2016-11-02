package chess.pieces;

import chess.MoveData;

public class Knight extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteKnight.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackKnight.png";
	
	public Knight(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	@Override
	public MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
