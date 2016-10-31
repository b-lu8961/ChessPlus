package chess;

public class MoveData {
	private int toRow;
	private int toCol;
	private boolean isACapture;
	
	public MoveData(int row, int col, boolean capture) {
		toRow = row;
		toCol = col;
		isACapture = capture;
	}
	
	public int getRow() {
		return toRow;
	}
	
	public int getCol() {
		return toCol;
	}
}
