package chess.pieces;

import java.util.ArrayList;

import chess.Board;
import chess.MoveData;

public class Rook extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteRook.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackRook.png";
	
	public Rook(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	@Override
	public MoveData[] getLegalMoves() {
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		boolean checkNorth = true;
		boolean checkSouth = true;
		boolean checkEast = true;
		boolean checkWest = true;
		
		for (int i = 1; i < 8; i ++) {
			//East squares
			if (checkEast && row + i < 8) {
				//Captures
				if (Board.getSquare(row + i, col) instanceof Piece) {
					if (Board.getSquare(row + i, col).getColor() != isWhite)
						moves.add(new MoveData(this, row, col, row + i, col, true));
					checkEast = false;
				}
				//Moves
				else
					moves.add(new MoveData(this, row, col, row + i, col, false));
			}
			
			//West squares
			if (checkWest && row - i > -1) {
				//Captures
				if (Board.getSquare(row - i, col) instanceof Piece) {
					if (Board.getSquare(row - i, col).getColor() != isWhite)
						moves.add(new MoveData(this, row, col, row - i, col, true));
					checkWest = false;
				}
				//Moves
				else
					moves.add(new MoveData(this, row, col, row - i, col, false));
			}
			
			//South squares
			if (checkSouth && col + i < 8) {
				//Captures
				if (Board.getSquare(row, col + i) instanceof Piece) {
					if (Board.getSquare(row, col + i).getColor() != isWhite)
						moves.add(new MoveData(this, row, col, row, col + i, true));
					checkSouth = false;
				}
				//Moves
				else
					moves.add(new MoveData(this, row, col, row, col + i, false));
			}
			
			//North squares
			if (checkNorth && col - i > -1) {
				//Captures
				if (Board.getSquare(row, col - i) instanceof Piece) {
					if (Board.getSquare(row, col - i).getColor() != isWhite)
						moves.add(new MoveData(this, row, col, row, col - i, true));
					checkNorth = false;
				}
				//Moves
				else
					moves.add(new MoveData(this, row, col, row, col - i, false));
			}
		}
		
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}

}
