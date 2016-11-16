package chess.pieces;

import java.util.ArrayList;

import chess.Board;
import chess.MoveData;

public class King extends Piece {
	private static final String whitePath = "PieceImages/Chess/White/WhiteKing.png";
	private static final String blackPath = "PieceImages/Chess/Black/BlackKing.png";
	private boolean hasMoved = false;
	
	public King(int row, int col, boolean isWhite) {
		super(whitePath, blackPath, row, col, isWhite);
	}
	
	//Need to implement check & checkmate situations, castling with rook
	
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
								moves.add(new MoveData(row, col, row + i, col + j, MoveData.CAPTURE));
						}
						//Moves
						else
							moves.add(new MoveData(row, col, row + i, col + j, MoveData.MOVE));
					}
				}
			}
		}
		
		//Castles
		int color = this.getColor() ? 7 : 0;
		if (!hasMoved) {
			Piece leftCorner = Board.getSquare(0, color);
			Piece rightCorner = Board.getSquare(0, color);
			if (leftCorner instanceof Rook && !((Rook) leftCorner).getMoveStatus()) {
				if (Board.getSquare(1, color) == null && Board.getSquare(2, color) == null && Board.getSquare(3, color) == null) {
					moves.add(new MoveData(row, col, row - 2, col, MoveData.CASTLE));
				}
			}
			if (rightCorner instanceof Rook && !((Rook) rightCorner).getMoveStatus()) {
				if (Board.getSquare(5, color) == null && Board.getSquare(6, color) == null) {
					moves.add(new MoveData(row, col, row + 2, col, MoveData.CASTLE));
				}
			}
		}
		MoveData[] movesArray = moves.toArray(new MoveData[moves.size()]);
		return movesArray;
	}

	public void setMoved() {
		hasMoved = true;
	}
}
