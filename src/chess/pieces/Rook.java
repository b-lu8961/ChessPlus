package chess.pieces;

import java.util.ArrayList;

import chess.Board;
import chess.MoveData;

public class Rook extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteRook.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackRook.png";
	private boolean hasMoved = false;
	
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
					if (Board.getSquare(row + i, col).getColor() != isWhite) {
						if (Board.getSquare(row + i, col) instanceof King) 
							moves.add(new MoveData(row, col, row + i, col, MoveData.CHECK));
						else
							moves.add(new MoveData(row, col, row + i, col, MoveData.CAPTURE));
					}
					checkEast = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row + i, col, MoveData.MOVE));
			}
			
			//West squares
			if (checkWest && row - i > -1) {
				//Captures
				if (Board.getSquare(row - i, col) instanceof Piece) {
					if (Board.getSquare(row - i, col).getColor() != isWhite) {
						if (Board.getSquare(row - i, col) instanceof King) 
							moves.add(new MoveData(row, col, row - i, col, MoveData.CHECK));
						else
							moves.add(new MoveData(row, col, row - i, col, MoveData.CAPTURE));
					}
					checkWest = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row - i, col, MoveData.MOVE));
			}
			
			//South squares
			if (checkSouth && col + i < 8) {
				//Captures
				if (Board.getSquare(row, col + i) instanceof Piece) {
					if (Board.getSquare(row, col + i).getColor() != isWhite) {
						if (Board.getSquare(row, col + i) instanceof King)
							moves.add(new MoveData(row, col, row, col + i, MoveData.CHECK));
						else
							moves.add(new MoveData(row, col, row, col + i, MoveData.CAPTURE));
					}
					checkSouth = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row, col + i, MoveData.MOVE));
			}
			
			//North squares
			if (checkNorth && col - i > -1) {
				//Captures
				if (Board.getSquare(row, col - i) instanceof Piece) {
					if (Board.getSquare(row, col - i).getColor() != isWhite) {
						if (Board.getSquare(row, col - i) instanceof King)
							moves.add(new MoveData(row, col, row, col - i, MoveData.CHECK));
						else
							moves.add(new MoveData(row, col, row, col - i, MoveData.CAPTURE));
					}
					checkNorth = false;
				}
				//Moves
				else
					moves.add(new MoveData(row, col, row, col - i, MoveData.MOVE));
			}
		}
		
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}

	public void setMoved() {
		hasMoved = true;
	}
	
	public boolean getMoveStatus() {
		return hasMoved;
	}
}
