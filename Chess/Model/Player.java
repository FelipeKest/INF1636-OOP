package Model;

import java.util.Arrays;

final class Player {
	
	private String name;
	private Color color;
	private Piece[] deadPieces;
	private Piece[] livePieces;
	
	protected Player(String name, Color color) {
		// TODO Auto-generated constructor stub
		
		this.name = name;
		this.color = color;
		
		this.deadPieces = null;
		this.livePieces = null;		
		
	}
	
	protected String getName() {
        return this.name;
    }	

	protected Color getColor() {
		return this.color;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setColor(Color c) {
		this.color = c;
	}
}
