package chess.pieces;

import chess.MoveData;

public abstract class Piece {
	private String whitePath;
	private String blackPath;
	private boolean isWhite;
	
	public Piece(String whitePath, String blackPath, boolean isWhite) {
		this.whitePath = whitePath;
		this.blackPath = blackPath;
		this.isWhite = isWhite;
	}
	
	public boolean getColor() {
		return isWhite;
	}
	
	public String getPath(boolean isWhite) {
		if (isWhite)
			return whitePath;
		else
			return blackPath;
	}
	
	abstract MoveData[] getLegalMoves();
}
