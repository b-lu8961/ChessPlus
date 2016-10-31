package chess.pieces;

import chess.MoveData;
import java.util.ArrayList;

public class Pawn extends Piece{
	private static final String whitePath = "PieceImages/Chess/White/WhitePawn.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackPawn.png";
	private boolean hasMoved = false;
	
	public Pawn(boolean isWhite) {
		super(whitePath, blackPath, isWhite);
	}
	
	public MoveData[] getLegalMoves() {
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}
}
