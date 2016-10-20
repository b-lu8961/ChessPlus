package chess;

public enum Piece {
	EMPTY(-1, ""),
	WHITE_PAWN(0, "PieceImages/Chess/White/WhitePawn.png"),
	WHITE_ROOK(1, "PieceImages/Chess/White/WhiteRook.png"),
	WHITE_KNIGHT(2, "PieceImages/Chess/White/WhiteKnight.png"),
	WHITE_BISHOP(3, "PieceImages/Chess/White/WhiteBishop.png"),
	WHITE_QUEEN(4, "PieceImages/Chess/White/WhiteQueen.png"),
	WHITE_KING(5, "PieceImages/Chess/White/WhiteKing.png"),
	BLACK_PAWN(6, "PieceImages/Chess/Black/BlackPawn.png"),
	BLACK_ROOK(7, "PieceImages/Chess/Black/BlackRook.png"),
	BLACK_KNIGHT(8, "PieceImages/Chess/Black/BlackKnight.png"),
	BLACK_BISHOP(9, "PieceImages/Chess/Black/BlackBishop.png"),
	BLACK_QUEEN(10, "PieceImages/Chess/Black/BlackQueen.png"),
	BLACK_KING(11, "PieceImages/Chess/Black/BlackKing.png");
	
	private int num;
	private String path;
	
	Piece(int num, String path) {
		this.num = num;
		this.path = path;
	}
	
	public int num() {
		return num;
	}
	public String path() {
		return path;
	}
	
	public static String getPath(int id) {
		String result = "";
		for (Piece p : Piece.values()) {
			if (id == p.num()) {
				result = p.path();
				break;
			}
		}
		return result;
	}
}
