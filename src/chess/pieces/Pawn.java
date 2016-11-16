package chess.pieces;

import chess.*;
import java.util.ArrayList;

public class Pawn extends Piece{
	private static final String whitePath = "PieceImages/Chess/White/WhitePawn.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackPawn.png";
	private int numMoves = 0;
	
	public Pawn(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}

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
		if ((col + dY > -1) && (col + dY < 8) && (Board.getSquare(row, col + dY) == null)) {
			moves.add(new MoveData(row, col, row, col + dY, MoveData.MOVE));
			/*
			 * Two squares ahead if pawn hasn't moved 
			 */
			if (numMoves == 0 && Board.getSquare(row, col + 2*dY) == null) {
				moves.add(new MoveData(row, col, row, col + 2*dY, MoveData.MOVE));
			}
		}
		
		/*
		 * Captures
		 */
		if ((row + 1 < 8) && (col + dY > -1) && (col + dY < 8)) {
			if (Board.getSquare(row + 1, col + dY) instanceof Piece) {
				if (Board.getSquare(row + 1, col + dY).getColor() != isWhite) {
					if (Board.getSquare(row + 1, col + dY) instanceof King)
						moves.add(new MoveData(row, col, row + 1, col + dY, MoveData.CHECK));
					else
						moves.add(new MoveData(row, col, row + 1, col + dY, MoveData.CAPTURE));
				}
			}
			//En passant capture
			if (Board.getSquare(row + 1, col) instanceof Pawn) {
				Pawn refPawn = (Pawn)Board.getSquare(row + 1, col);
				if (refPawn.getNumMoves() == 1) 
					moves.add(new MoveData(row, col, row + 1, col + dY, MoveData.EN_PASSANT));
			}
		}
		if ((row - 1 > -1) && (col + dY > -1) && (col + dY < 8)) {
			if (Board.getSquare(row - 1, col + dY) instanceof Piece) {
				if (Board.getSquare(row - 1, col + dY).getColor() != isWhite) {
					if (Board.getSquare(row - 1, col + dY) instanceof King)
						moves.add(new MoveData(row, col, row - 1, col + dY, MoveData.CHECK));
					else
						moves.add(new MoveData(row, col, row - 1, col + dY, MoveData.CAPTURE));
				}
			}
			//En passant capture
			if (Board.getSquare(row - 1, col) instanceof Pawn) {
				Pawn refPawn = (Pawn)Board.getSquare(row - 1, col);
				if (refPawn.getNumMoves() == 1) 
					moves.add(new MoveData(row, col, row - 1, col + dY, MoveData.EN_PASSANT));
			}
		}
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}
	
	public void setMoved() {
		numMoves++;
	}
	
	public int getNumMoves() {
		return numMoves;
	}
} //end class Pawn
