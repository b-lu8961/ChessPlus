package chess.pieces;

import java.util.ArrayList;

import chess.Board;
import chess.MoveData;

public class Bishop extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteBishop.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackBishop.png";
	
	public Bishop(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	
	public MoveData[] getLegalMoves() {
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		boolean checkNE = true;
		boolean checkSW = true;
		boolean checkSE = true;
		boolean checkNW = true;
		
		for (int i = 1; i < 8; i ++) {
			//SE squares
			if (checkSE && row + i < 8 && col + i < 8) {
				//Captures
				if (Board.getSquare(row + i, col + i) instanceof Piece) {
					if (Board.getSquare(row + i, col + i).getColor() != isWhite)
						moves.add(new MoveData(row, col, row + i, col + i, true));
					checkSE = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row + i, col + i, false));
			}
			
			//NW squares
			if (checkNW && row - i > -1 && col - i > -1) {
				//Captures
				if (Board.getSquare(row - i, col - i) instanceof Piece) {
					if (Board.getSquare(row - i, col - i).getColor() != isWhite)
						moves.add(new MoveData(row, col, row - i, col - i, true));
					checkNW = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row - i, col - i, false));
			}
			
			//SW squares
			if (checkSW && row - i > -1 && col + i < 8) {
				//Captures
				if (Board.getSquare(row - i, col + i) instanceof Piece) {
					if (Board.getSquare(row - i, col + i).getColor() != isWhite)
						moves.add(new MoveData(row, col, row - i, col + i, true));
					checkSW = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row - i, col + i, false));
			}
			
			//NE squares
			if (checkNE && row + i < 8 && col - i > -1) {
				//Captures
				if (Board.getSquare(row + i, col - i) instanceof Piece) {
					if (Board.getSquare(row + i, col - i).getColor() != isWhite)
						moves.add(new MoveData(row, col, row + i, col - i, true));
					checkNE = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row + i, col - i, false));
			}
		}
		
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}

}
