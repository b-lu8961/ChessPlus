package chess.pieces;

import java.util.ArrayList;

import chess.MoveData;

public class Bishop extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteBishop.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackBishop.png";
	
	public Bishop(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	
	public MoveData[] getLegalMoves() {
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}

}
