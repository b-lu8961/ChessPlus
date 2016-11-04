package chess;

public class MoveData {
	private int toRow;
	private int toCol;
	private int fromRow;
	private int fromCol;
	private boolean isACapture;
	
	/**
	 * Constructor to create a MoveData object.
	 * @param startPiece piece to be moved
	 * @param fromRow 	starting row of moving piece
	 * @param fromCol 	starting column of moving piece
	 * @param toRow 	ending row of moving piece
	 * @param toCol 	ending column of moving piece
	 * @param capture 	true if move is a capture, else is false
	 */
	public MoveData(int fromRow, int fromCol, int toRow, int toCol, boolean capture) {
		this.fromRow = fromRow;
		this.fromCol = fromCol;
		this.toRow = toRow;
		this.toCol = toCol;
		isACapture = capture;
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
	public boolean checkCapture() {
		return isACapture;
	}
} //end class MoveData
