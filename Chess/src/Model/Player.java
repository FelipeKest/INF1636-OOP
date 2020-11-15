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
	
	protected Piece[] addLivePiece(Piece p) {
		// TODO: Check if the piece isn't already live
		p.live();
		Piece ps[] = Arrays.copyOf(this.livePieces, this.livePieces.length + 1);
		ps[ps.length-1] = p;
		return ps;
	}
	
	protected Piece[] addDeadPiece(Piece p) {
		// TODO: Check if the piece isn't already dead
		p.die();
		Piece ps[] = Arrays.copyOf(this.deadPieces, this.deadPieces.length + 1);
		ps[ps.length-1] = p;
		return ps;
	}
}
