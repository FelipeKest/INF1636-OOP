package Model;

final class MoveManager {
	
	protected static MoveManager MM;
	
	private MoveManager() {
		
	}
	
	public static MoveManager getInstanceMM() {
		if (MM == null) {
			MM = new MoveManager();
		}
		return MM;
	}
	
	
//	Position[] possiblePositions(Position origin) {
//		Position[] destinies;
//		destinies[0] = new Position(0,1);
//		
//		return destinies;
//	}
	
	protected Position pawnPosition(Position current) {
		// TODO: Change Piece to rook
		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
	}
	
	protected Position[] rookPositions(Position current) {
		
		// TODO: Change Piece to rook
		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
		// Vector of possible positions for a rook (8V - Current)+(8H-Current) = 14
		Position possible[] = new Position[14];
		int i=0;
		
		Coordinate c = current.coordinate;
		int xPosition = c.x;
		// Check for available positions in x coordinate
		while (xPosition<8) {
			Position nextXPosition = new Position(xPosition+1,c.y);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.color == r.color) {
					// same player
					break;
				} else {
					// other player
					possible[i] = nextXPosition;
					break;
				}
			} else {
				possible[i] = nextXPosition;
			}
			xPosition++;
			i++;
		}
		
		xPosition = c.x;
		
		while (xPosition>0) {
			Position nextXPosition = new Position(xPosition-1,c.y);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.color == r.color) {
					// same player
					break;
				} else {
					// other player
					possible[i] = nextXPosition;
					i++;
					break;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
			xPosition--;
			i++;
		}
		
		int yPosition = c.y;
		
		while (yPosition<8) {
			Position nextXPosition = new Position(c.x,yPosition+1);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.color == r.color) {
					// same player
					break;
				} else {
					// other player
					possible[i] = nextXPosition;
					break;
				}
			} else {
				possible[i] = nextXPosition;
			}
			yPosition++;
			i++;
		}
		
		while (c.y>0) {
			Position nextYPosition = new Position(c.x,yPosition-1);
			if (nextYPosition.occupiedBy != null) {
				if (nextYPosition.occupiedBy.color == r.color) {
					// same player
					break;
				} else {
					// other player
					possible[i] = nextYPosition;
					break;
				}
			} else {
				possible[i] = nextYPosition;
			}
			yPosition--;
			i++;
		}
		
		return possible;
		
	}
	
	/*
	private Position[] bishopPositions(Position current) {
		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
		// Vector of possible positions for a rook (8V - Current)+(8H-Current) = 14
		Position possible[] = new Position[14];
		int i=0;
		
		Coordinate c = current.coordinate;
		
		while (c.y>0) {
			int nextY = c.y++;
			Position nextYPosition = new Position(c.x,c.y+1);
			if (nextYPosition.occupiedBy != null) {
				if (nextYPosition.occupiedBy.color == r.color) {
					// same player
					break;
				} else {
					// other player
					possible[i] = nextYPosition;
					break;
				}
			} else {
				possible[i] = nextYPosition;
			}
			c.y++;
		}
		
		return possible;
	}
	
	*/
}
