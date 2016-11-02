package chess.pieces;

import chess.MoveData;

public class Rook extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteRook.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackRook.png";
	
	public Rook(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	@Override
	public MoveData[] getLegalMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
