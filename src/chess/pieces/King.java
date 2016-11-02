package chess.pieces;

import chess.MoveData;

public class King extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteKing.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackKing.png";
	
	public King(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	@Override
	public MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
