package Model;

public abstract class Piece {
	boolean isAlive;
	Color color;
	
	Piece(Color c) {
		this.isAlive = true;
		this.color = c;
	}
	
	public void move(Position newPosition) { }
	
	public void die() {
		this.isAlive = false;
	}
	
}
