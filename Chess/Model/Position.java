package Model;

import java.util.Arrays;
import Model.Piece;
import Utils.PieceType;

final class Position {
	
	public Coordinate coordinate;
	protected Piece occupiedBy;
	
	protected Position(int x, int y) {
		this.coordinate = new Coordinate(x,y);
		this.occupiedBy = null;
	}
	
	protected Position(int x, int y, Piece p) {
		this.coordinate = new Coordinate(x,y);
		this.occupiedBy = p;
	}
	
	protected static Position stringToPos(String x, String y, String pieceType, String color) {
		int xAsInt = Integer.valueOf(x);
		int yAsInt = Integer.valueOf(y);
		if (pieceType.equals("-1")) {
			return new Position(xAsInt,yAsInt);			
		}
		int pieceTypeasInt = Integer.valueOf(pieceType);
		int colorAsInt = Integer.valueOf(color);
		PieceType pt = PieceType.typeFromInt(pieceTypeasInt);
		Color c = Color.typeFromInt(colorAsInt);
		Piece p = new Piece(pt,c);
		return new Position(xAsInt,yAsInt,p);
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
		int val[] = new int[4];
		val[0] = this.coordinate.x;
		val[1] = this.coordinate.y;
		if (this.occupiedBy == null) {
			val[2] = -1;
			val[3] = -1;
		} else {
			val[2] = this.occupiedBy.getPieceType().ordinal(); // opposite of PieceType.values()[val];
			val[3] = this.occupiedBy.getColor().ordinal();
		} 
		return val;
	}
}
