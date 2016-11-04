package chess.pieces;

import chess.Board;
import chess.MoveData;
import java.util.ArrayList;

public class Knight extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteKnight.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackKnight.png";
	
	public Knight(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	@Override
	public MoveData[] getLegalMoves() {
		ArrayList<MoveData> moves = new ArrayList<MoveData>();
		for (int i = -2; i < 3; i ++) {
			for (int j = -2; j < 3; j++) {
				if ((Math.abs(i) == 2 && Math.abs(j) == 1) || (Math.abs(i) == 1 && Math.abs(j) == 2)) {
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
