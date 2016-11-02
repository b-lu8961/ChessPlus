package chess.pieces;

import chess.MoveData;

public class Queen extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteQueen.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackQueen.png";
	
	public Queen(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	@Override
	public MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
