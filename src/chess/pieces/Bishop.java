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
					if (Board.getSquare(row + i, col + i).getColor() != isWhite) {
						if (Board.getSquare(row + i, col + i) instanceof King)
							moves.add(new MoveData(row, col, row + i, col + i, MoveData.CHECK));
						else
							moves.add(new MoveData(row, col, row + i, col + i, MoveData.CAPTURE));
					}
					checkSE = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row + i, col + i, MoveData.MOVE));
			}
			
			//NW squares
			if (checkNW && row - i > -1 && col - i > -1) {
				//Captures
				if (Board.getSquare(row - i, col - i) instanceof Piece) {
					if (Board.getSquare(row - i, col - i).getColor() != isWhite) {
						if (Board.getSquare(row - i, col - i) instanceof King)
							moves.add(new MoveData(row, col, row - i, col - i, MoveData.CHECK));
						else
							moves.add(new MoveData(row, col, row - i, col - i, MoveData.CAPTURE));
					}
					checkNW = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row - i, col - i, MoveData.MOVE));
			}
			
			//SW squares
			if (checkSW && row - i > -1 && col + i < 8) {
				//Captures
				if (Board.getSquare(row - i, col + i) instanceof Piece) {
					if (Board.getSquare(row - i, col + i).getColor() != isWhite) {
						if (Board.getSquare(row - i, col + i) instanceof King) 
							moves.add(new MoveData(row, col, row - i, col + i, MoveData.CHECK));
						else
							moves.add(new MoveData(row, col, row - i, col + i, MoveData.CAPTURE));
					}
					checkSW = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row - i, col + i, MoveData.MOVE));
			}
			
			//NE squares
			if (checkNE && row + i < 8 && col - i > -1) {
				//Captures
				if (Board.getSquare(row + i, col - i) instanceof Piece) {
					if (Board.getSquare(row + i, col - i).getColor() != isWhite) {
						if (Board.getSquare(row + i, col - i) instanceof King) 
							moves.add(new MoveData(row, col, row + i, col - i, MoveData.CHECK));
						else
							moves.add(new MoveData(row, col, row + i, col - i, MoveData.CAPTURE));
					}
					checkNE = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row + i, col - i, MoveData.MOVE));
			}
		}
		
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}

}
