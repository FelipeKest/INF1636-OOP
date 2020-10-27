package Model;

public abstract class Piece {
	Position position;
	boolean isAlive;
	Color color;
	PieceType type;
	
	Piece() {
		
	}
	
	public void move(Position newPosition) {
		this.position = newPosition;
	}
	
	public void die() {
		this.isAlive = true;
	}
	
	public abstract void movePattern();
	
}
