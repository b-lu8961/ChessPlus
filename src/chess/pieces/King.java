package chess.pieces;

import java.util.ArrayList;

import chess.Board;
import chess.MoveData;

public class King extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteKing.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackKing.png";
	
	public King(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	//Need to implement check & checkmate situations
	
	@Override
	public MoveData[] getLegalMoves() {
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		for (int i = -1; i < 2; i ++) {
			for (int j = -1; j < 2; j++) {
				if (!(i == 0 && j == 0)) {
					if ((row + i > -1) && (row + i < 8) && (col + j > -1) && (col + j < 8)) {
						//Captures
						if (Board.getSquare(row + i, col + j) instanceof Piece) {
							if (Board.getSquare(row + i, col + j).getColor() != isWhite)
								moves.add(new MoveData(this, row, col, row + i, col + j, true));
						}
						//Moves
						else
							moves.add(new MoveData(this, row, col, row + i, col + j, false));
					}
				}
			}
		}
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}

}
