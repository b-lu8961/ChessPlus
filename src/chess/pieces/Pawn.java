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
	
	//Need to implement en passant, pawn promotion

	@Override
	public MoveData[] getLegalMoves() { 
		int dY;
		if (isWhite)
			dY = -1; //Moves up board if white
		else
			dY = 1; //Moves down board if black
		
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		/*
		 * One square ahead
		 */
		if ((Board.getSquare(row, col + dY) == null) && (col + dY > -1) && (col + dY < 8)) {
			moves.add(new MoveData(this, row, col, row, col + dY, false));
			/*
			 * Two squares ahead if haven't moved 
			 */
			if (!hasMoved && Board.getSquare(row, col + 2*dY) == null) {
				moves.add(new MoveData(this, row, col, row, col + 2*dY, false));
			}
		}
		
		/*
		 * Captures
		 */
		if ((row + 1 < 8) && (col + dY > -1) && (col + dY < 8)) {
			if (Board.getSquare(row + 1, col + dY) instanceof Piece) {
				if (Board.getSquare(row + 1, col + dY).getColor() != isWhite)
					moves.add(new MoveData(this, row, col, row + 1, col + dY, true));
			}
		}
		if ((row - 1 > -1) && (col + dY > -1) && (col + dY < 8)) {
			if (Board.getSquare(row - 1, col + dY) instanceof Piece) {
				if (Board.getSquare(row - 1, col + dY).getColor() != isWhite)
					moves.add(new MoveData(this, row, col, row - 1, col + dY, true));
			}
		}
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}
	
	public void setMoved() {
		hasMoved = true;
	}
} //end class Pawn
