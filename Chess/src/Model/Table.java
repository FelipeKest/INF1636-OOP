package Model;

public final class Table {
	
	private Position positions[];

	protected static Table table;
	
	private Table() {
		this.positions = fillTable();
	}
	
	protected static Table getTableInstance() {
		if (table == null) {
			table = new Table();
		}
		return table;
	}
	
	protected Position[] getAllPositions() {
		return this.positions;
	}	
	
	protected Position getPositionByCoordinate(Coordinate c) throws Exception {
		Position[] positions = getAllPositions();
		Position p = new Position(c.x,c.y);
		for (int i = 0; i<positions.length; i++) {
			if (Position.checkEqualCoordinate(positions[i], p)) {
				return positions[i];
			}
		}
		throw new Exception("Invalid Coordinate");
	}
	
	protected void changePositions(Position p) {
		for (int i = 0; i < positions.length; i++) {
			Position indexed = this.positions[i];	
			if (indexed.coordinate == p.coordinate) {
				this.positions[i] = p;
				return;
			}
		}
		
	}
	
	private Position[] fillTable() {
		// TODO: Fill Positions with correct pieces
		Position allPositions[] = new Position[64];
		int pos = 0;
		for (int i = 1; i<9;i++) {
			for (int j = 1; j<9; j++) {
				allPositions[pos] = new Position(i,j);
				pos++;
			}
		}
		return allPositions;
	}
	
	

	protected Position[] findPawnAvailablePositions(Position current) {
		// TODO: Change Piece to Pawn
		
		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
		Position[] possible = new Position[4];
	
		
		return possible;
		
	}
	
	protected Position[] findRookAvailablePositions(Position current) {
		
		// TODO: Change Piece to rook
		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
		// Vector of possible positions for a rook (8V - Current)+(8H-Current) = 14
		Position possible[] = new Position[14];
		int i=0;

		Coordinate c = current.coordinate;
		Coordinate aux = new Coordinate(c.x,c.y);
		
		// Check for available positions in x coordinate
		while (aux.x<9) {
			
			Position nextXPosition;
			System.out.println("X++ - i = "+i);
			try {	
				aux.x++;
				// Verify if position is on table, and gets its position if exists
				nextXPosition = this.getPositionByCoordinate(aux);
			} catch (Exception e) {
				// Position doesn't exist on table
				System.out.println("Position Doesnt exist on table");
				break;
			}
			
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
		}
		
		aux.x = c.x;
		aux.y = c.y;
		
		while (aux.x>0) {
			
			Position nextXPosition;
			System.out.println("X-- - i = "+i);
			try {
				aux.x--;
				nextXPosition = this.getPositionByCoordinate(aux);
			} catch (Exception e) {
				// Position doesn't exist on table
				System.out.println("Position Doesnt exist on table");
				break;
			}
			
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
		}
			
		aux.x = c.x;
		aux.y = c.y;
		
		while (aux.y<8) {
			
			Position nextYPosition;
			
			try {
				aux.y++;
				nextYPosition = this.getPositionByCoordinate(aux);
			} catch (Exception e) {
				break;
			}
			
			if (nextYPosition.occupiedBy != null) {
				if (nextYPosition.occupiedBy.color == r.color) {
					// same player
					break;
				} else {
					// other player
					possible[i] = nextYPosition;
					i++;
					break;
				}
			} else {
				possible[i] = nextYPosition;
				i++;
			}
		}
		
		aux.x = c.x;
		aux.y = c.y;
		
		while (aux.y>0) {
			
			Position nextYPosition;
			
			try {
				aux.y--;
				nextYPosition = this.getPositionByCoordinate(aux);
			} catch (Exception e) {
				break;
			}
			
			if (nextYPosition.occupiedBy != null) {
				if (nextYPosition.occupiedBy.color == r.color) {
					// same player
					break;
				} else {
					// other player
					possible[i] = nextYPosition;
					i++;
					break;
				}
			} else {
				possible[i] = nextYPosition;
				i++;
			}
		}	
		return possible;
	}
	
	Position[] findBishopAvailablePositions(Position current) {
		
			// TODO: Change Piece to rook
			Piece r = current.occupiedBy;
			if (r == null) {
				return null;
			}
			
			// Vector of possible positions for a rook (8V - Current)+(8H-Current) = 14
			Position possible[] = new Position[14];
			int i=0;

			Coordinate c = current.coordinate;
			Coordinate aux = new Coordinate(c.x,c.y);
			
			// Check for available positions in x coordinate
			while (aux.x<9) {
				
				Position nextXPosition;
				try {	
					aux.x++;
					// Verify if position is on table, and gets its position if exists
					nextXPosition = this.getPositionByCoordinate(aux);
				} catch (Exception e) {
					// Position doesn't exist on table
					System.out.println("Position Doesnt exist on table");
					break;
				}
				
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
			}
			
			aux.x = c.x;
			aux.y = c.y;
			
			
			while (aux.x>0) {
				
				Position nextXPosition;
				try {
					aux.x--;
					nextXPosition = this.getPositionByCoordinate(aux);
				} catch (Exception e) {
					// Position doesn't exist on table
					System.out.println("Position Doesnt exist on table");
					break;
				}
				
				if (nextXPosition.occupiedBy != null) {
					System.out.println("");
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
			}
				
			aux.x = c.x;
			aux.y = c.y;
			
			while (aux.y<8) {
				
				Position nextYPosition;
				
				try {
					aux.y++;
					nextYPosition = this.getPositionByCoordinate(aux);
				} catch (Exception e) {
					break;
				}
				
				if (nextYPosition.occupiedBy != null) {
					if (nextYPosition.occupiedBy.color == r.color) {
						// same player
						break;
					} else {
						// other player
						possible[i] = nextYPosition;
						i++;
						break;
					}
				} else {
					possible[i] = nextYPosition;
					i++;
				}
			}
			
			aux.x = c.x;
			aux.y = c.y;
			
			while (aux.y>0) {
				
				Position nextYPosition;
				
				try {
					aux.y--;
					nextYPosition = this.getPositionByCoordinate(aux);
				} catch (Exception e) {
					break;
				}
				
				if (nextYPosition.occupiedBy != null) {
					if (nextYPosition.occupiedBy.color == r.color) {
						// same player
						break;
					} else {
						// other player
						possible[i] = nextYPosition;
						i++;
						break;
					}
				} else {
					possible[i] = nextYPosition;
					i++;
				}
			}	
			return possible;
		}
 	
}
