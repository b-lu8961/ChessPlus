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
	
	public MoveData[] getLegalMoves() { //Need en passant
		int oldRow = row;
		int oldCol = this.getCol();
		int dY;
		if (getColor())
			dY = -1;
		else
			dY = 1;
		
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		if ((Board.getSquare(oldRow, oldCol + dY) == null) && (oldCol + dY > -1) && (oldCol + dY < 8)) {
			moves.add(new MoveData(this, oldRow, oldCol, oldRow, oldCol + dY, false));
			
			if (!hasMoved && Board.getSquare(oldRow, oldCol + 2*dY) == null) {
				moves.add(new MoveData(this, oldRow, oldCol, oldRow, oldCol + 2*dY, false));
			}
		}
		if ((oldRow + 1 < 8) && (oldCol + dY > -1) && (oldCol + dY < 8)) {
			if (Board.getSquare(oldRow + 1, oldCol + dY) instanceof Piece) {
				if (Board.getSquare(oldRow + 1, oldCol + dY).getColor() != getColor())
					moves.add(new MoveData(this, oldRow, oldCol, oldRow + 1, oldCol + dY, true));
			}
		}
		if ((oldRow - 1 > -1) && (oldCol + dY > -1) && (oldCol + dY < 8)) {
			if (Board.getSquare(oldRow - 1, oldCol + dY) instanceof Piece) {
				if (Board.getSquare(oldRow - 1, oldCol + dY).getColor() != getColor())
					moves.add(new MoveData(this, oldRow, oldCol, oldRow - 1, oldCol + dY, true));
			}
		}
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}
	
	public void setMoved() {
		hasMoved = true;
	}
} //end class Pawn
