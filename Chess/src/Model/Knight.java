package Model;

final class Knight extends Piece {

	protected Knight(Color c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	
	//TODO: Implement Check/Checkmate logic
	
	protected boolean checkForValidMoves(Position p) {
		// Check for each enemy's piece if they can take your king -> returns if in check
		// Check if there is a valid move to escape the check -> if there is !checkmate, else checkmate
		boolean checkmate,check;
		return true;
	}
}
