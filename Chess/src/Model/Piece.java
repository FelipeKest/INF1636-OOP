package Model;

public abstract class Piece {
	boolean isAlive;
	Color color;
	
	Piece(Color c) {
		this.isAlive = true;
		this.color = c;
	}
	
	protected void die() {
		this.isAlive = false;
	}
	
	protected void live() {
		this.isAlive = true;
	}
	
}
