package Model;

import Utils.PieceType;

class Piece {
	boolean isAlive;
	private PieceType type;
	private Color color;
	
	protected Piece(PieceType type, Color color) {
		this.isAlive = true;
		this.type = type;
		this.color = color;
		
	}
	
	protected PieceType getPieceType() {
		return this.type;
		
	}
	
	protected void setPieceType(PieceType type) { 
		this.type = type;
		
	}
	
	protected Color getColor() {
		return this.color;
		
	}	

	protected void die() {
		this.isAlive = false;
	}
	
	protected void live() {
		this.isAlive = true;
	}
	
}
