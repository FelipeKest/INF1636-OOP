package Model;

public abstract class Piece {
	boolean isAlive;
	Color color;
	
	Piece() {
		
	}
	
	public void move(Position newPosition) { }
	
	public void die() {
		this.isAlive = true;
	}
	
	public abstract void movePattern();
	
}
