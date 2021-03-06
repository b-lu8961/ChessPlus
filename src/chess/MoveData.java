package chess;

public class MoveData {
	private int toRow, toCol;
	private int fromRow, fromCol;
	private int moveType;
	public static final int MOVE = 1,
							CASTLE = 2,
							CAPTURE = -1,
							CHECK = -2,
							EN_PASSANT = -3;
	
	/**
	 * Constructor to create a MoveData object.
	 * @param startPiece piece to be moved
	 * @param fromRow 	starting row of moving piece
	 * @param fromCol 	starting column of moving piece
	 * @param toRow 	ending row of moving piece
	 * @param toCol 	ending column of moving piece
	 * @param capture 	true if move is a capture, else is false
	 */
	public MoveData(int fromRow, int fromCol, int toRow, int toCol, int moveType) {
		this.fromRow = fromRow;
		this.fromCol = fromCol;
		this.toRow = toRow;
		this.toCol = toCol;
		this.moveType = moveType;
	} //end constructor
	
	public int getStartRow() {
		return fromRow;
	}
	
	public int getStartCol() {
		return fromCol;
	}
	
	public int getEndRow() {
		return toRow;
	}
	
	public int getEndCol() {
		return toCol;
	}
	public int checkMoveType() {
		return moveType;
	}
} //end class MoveData
