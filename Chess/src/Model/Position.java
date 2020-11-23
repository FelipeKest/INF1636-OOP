package Model;

import java.util.Arrays;

final class Position extends PieceObserved {
	
	public Coordinate coordinate;
	protected Piece occupiedBy;
	
	protected Position(int x, int y) {
		this.coordinate = new Coordinate(x,y);
	}
	
	protected Position(int x, int y, Piece p) {
		this.coordinate = new Coordinate(x,y);
		this.occupiedBy = p;
	}
	
	protected static boolean checkEqualCoordinate(Position p1, Position p2) {
		return p1.coordinate.x == p2.coordinate.x && p1.coordinate.y == p2.coordinate.y;
	}
	
	protected static Position[] appendPositionToArray(Position arr[], Position p) {
		Position ps[] = Arrays.copyOf(arr, arr.length + 1);
		ps[ps.length-1] = p;
		return ps;
	}

	protected void update(Piece p) {
		this.occupiedBy = p;
	}
	
	protected int[] mapToInt() {
		int val[] = new int[3];
		val[0] = this.coordinate.x;
		val[1] = this.coordinate.y;
		val[2] = this.occupiedBy.getPieceType().ordinal(); // opposite of PieceType.values()[val];
		return val;
	}
}
