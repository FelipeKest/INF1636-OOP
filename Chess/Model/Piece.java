package Model;

import Utils.PieceType;

class Piece {
	private boolean isAlive;
	private PieceType type;
	private Color color;
	private boolean hasMoved;
	
	protected Piece(PieceType type, Color color) {
		this.isAlive = true;
		this.type = type;
		this.color = color;
		this.hasMoved = false;
		
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
	
	protected boolean getHasMoved() {
		return this.hasMoved;
	}

	protected void die() {
		this.isAlive = false;
	}
	
	protected void live() {
		this.isAlive = true;
	}
	
	protected void moved() {
		this.hasMoved = true;
	}
	
}
