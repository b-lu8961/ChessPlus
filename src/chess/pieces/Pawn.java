package chess.pieces;

import chess.*;
import java.util.ArrayList;

public class Pawn extends Piece{
	private static final String whitePath = "PieceImages/Chess/White/WhitePawn.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackPawn.png";
	private boolean hasMoved = false;
	
	public Pawn(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	public MoveData[] getLegalMoves() {
		int oldRow = this.getRow();
		int oldCol = this.getCol();
		int dY;
		if (getColor())
			dY = -1;
		else
			dY = 1;
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		if ((Board.getSquare(oldRow, oldCol + dY) == null) && (oldCol + dY > -1) && (oldCol + dY < 8)) {
			moves.add(new MoveData(oldRow, oldCol + dY, false));
			
			if (!hasMoved && Board.getSquare(oldRow, oldCol + 2*dY) == null) {
				moves.add(new MoveData(oldRow, oldCol + 2*dY, false));
			}
		}
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}
	
	public void setMoveStatus() {
		hasMoved = true;
	}
}
