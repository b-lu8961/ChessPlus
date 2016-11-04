package chess.pieces;

import java.util.ArrayList;

import chess.MoveData;

public class Queen extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteQueen.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackQueen.png";
	
	public Queen(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	@Override
	public MoveData[] getLegalMoves() {
		MoveData[] rookArray;
		MoveData[] bishopArray;
		Rook ghostRook = new Rook(row, col, isWhite);
		rookArray = ghostRook.getLegalMoves();
		
		Bishop ghostBishop = new Bishop(row, col, isWhite);
		bishopArray = ghostBishop.getLegalMoves();
		
		int total = rookArray.length + bishopArray.length;
		MoveData[] movesArray = new MoveData[total];
		for (int i = 0; i < total; i++) {
			if (i < rookArray.length) {
				movesArray[i] = rookArray[i];
			}
			else
				movesArray[i] = bishopArray[i - rookArray.length];
		}
		//ArrayList<MoveData> moves = new ArrayList<MoveData>();
		//MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}

}
