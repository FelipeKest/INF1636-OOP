package Model;
import Utils.*;

import java.util.ArrayList;
import java.util.List;

import Utils.PieceObserved;
import Utils.PieceObserver;
import Utils.PieceType;

final public class Table implements PieceObserved {
	
	private Position positions[];
	
	private int[][] visualPositions = new int[64][4];

	List<PieceObserver> list = new ArrayList<PieceObserver>();
	
	public void add(PieceObserver observer) {
		this.list.add(observer);
	}

	public void remove(PieceObserver observer) {
		this.list.remove(observer);
	}

	public int[][] getVisualPositions() {
		return this.visualPositions;
	}
		
	protected static Table table;
	
	private Table() {
		this.positions = fillTable();
		this.generateVisualPositions();
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
	
	protected Position getPositionByCoordinate(Coordinate c) {
		Position[] positions = getAllPositions();
		Position p = new Position(c.x,c.y);
		for (int i = 0; i<positions.length; i++) {
			if (Position.checkEqualCoordinate(positions[i], p)) {
				return positions[i];
			}
		}
		return null;
	}
	
    protected void notifyPositions(Position p) {
    	System.out.println("hello");
        updatePositions(p);
        for (PieceObserver observer: list) {
        	observer.notifyPositions(this);
        }
    }
	
	private void updatePositions(Position p) {
		for (int i = 0; i < positions.length; i++) {
			Position indexed = this.positions[i];
			if (Position.checkEqualCoordinate(indexed, p)) {
				this.positions[i] = p;
				this.generateVisualPositions();
				return;
			}
		}
	}
	
	protected void generateVisualPositions() {
		int i = 0;
		for (Position p: this.getAllPositions()) {
			this.visualPositions[i] = p.mapToInt();
			i++;
		} 
	}
	
	private Position[] fillTable() {
		Position allPositions[] = new Position[64];
		int pos = 0;
		for (int i = 1; i<9;i++) {
			for (int j = 1; j<9; j++) {
				if (j==1) {
					if (i==1 || i==8) {
//						Piece r = new Piece(PieceType.ROOK,Color.WHITE);
						Piece r = new Piece(PieceType.ROOK,Color.WHITE);
						allPositions[pos] = new Position(i,j,r);
					} else if (i==2 || i==7){
						Piece k = new Piece(PieceType.KNIGHT,Color.WHITE);
						allPositions[pos] = new Position(i,j,k);
					} else if (i==3 || i==6) {
						Piece b = new Piece(PieceType.BISHOP,Color.WHITE);
						allPositions[pos] = new Position(i,j,b);
					} else if (i==4) {
						Piece k = new Piece(PieceType.KING,Color.WHITE);
						allPositions[pos] = new Position(i,j,k);
					} else {
						Piece q = new Piece(PieceType.QUEEN,Color.WHITE);
						allPositions[pos] = new Position(i,j,q);
					}
				} else if (j==2) {
					Piece p = new Piece(PieceType.PAWN,Color.WHITE);
					allPositions[pos] = new Position(i,j,p);
				} else if (j==7) {
					Piece p = new Piece(PieceType.PAWN,Color.BLACK);
					allPositions[pos] = new Position(i,j,p);
				} else if (j==8) {
					if (i==1 || i==8) {
						Piece r = new Piece(PieceType.ROOK,Color.BLACK);
						allPositions[pos] = new Position(i,j,r);
					} else if (i==2 || i==7){
						Piece k = new Piece(PieceType.KNIGHT,Color.BLACK);
						allPositions[pos] = new Position(i,j,k);
					} else if (i==3 || i==6) {
						Piece b = new Piece(PieceType.BISHOP,Color.BLACK);
						allPositions[pos] = new Position(i,j,b);
					} else if (i==4) {
						Piece q = new Piece(PieceType.QUEEN,Color.BLACK);
						allPositions[pos] = new Position(i,j,q);
					} else {
						Piece k = new Piece(PieceType.KING,Color.BLACK);
						allPositions[pos] = new Position(i,j,k);
					}
				} else {
					allPositions[pos] = new Position(i,j);
				}
				pos++;
			}
		}
		return allPositions;
	}
	
	protected Position[] findAvailablePositions(Position current) {

		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
		
		switch (current.occupiedBy.getPieceType()) {
		case QUEEN:
			return findQueenAvailablePositions(current);
		case PAWN:
			return findPawnAvailablePositions(current);
		case KNIGHT:
			return findKnightAvailablePositions(current);
		case BISHOP:
			return findBishopAvailablePositions(current);
		case ROOK:
			return findRookAvailablePositions(current);
		case KING:
			try {
				return findKingAvailablePositions(current);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	private Position[] findPawnAvailablePositions(Position current) {
		
		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
		Position[] posible = {};
		
		Coordinate c = current.coordinate;
		Coordinate aux = new Coordinate(c.x,c.y);
		
		if (r.getColor() == Color.WHITE) {
			Position p1 = new Position(c.x,c.y+1);
			posible = Position.appendPositionToArray(posible, p1);
			if (c.y == 2) {
				Position p2 = new Position(c.x,c.y+2);
				posible = Position.appendPositionToArray(posible, p2);
			}
			
			// check diagonals
			// Upper Left
			aux.x--;
			aux.y++;
			
			Position contested = null;
			try {
				contested = getPositionByCoordinate(aux);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (contested.occupiedBy != null) {
				if (contested.occupiedBy.getColor() != r.getColor()) {
				// Other player, can eat the piece
					posible = Position.appendPositionToArray(posible, contested);
				}
			}
			
			// Upper Right
			aux.x+=2;
			
			try {
				contested = getPositionByCoordinate(aux);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (contested.occupiedBy != null) {
				if (contested.occupiedBy.getColor() != r.getColor()) {
				// Other player, can eat the piece
					posible = Position.appendPositionToArray(posible, contested);
				}
			}
		} else {
			Position p1 = new Position(c.x,c.y-1);
			posible = Position.appendPositionToArray(posible, p1);
			if (c.y == 7) {
				Position p2 = new Position(c.x,c.y-2);
				posible = Position.appendPositionToArray(posible, p2);
			}
			
			// check diagonals
			// Down Left
			aux.x--;
			aux.y--;
			
			Position contested = null;
			try {
				contested = getPositionByCoordinate(aux);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (contested.occupiedBy != null) {
				if (contested.occupiedBy.getColor() != r.getColor()) {
				// Other player, can eat the piece
					posible = Position.appendPositionToArray(posible, contested);
				}
			}
			
			// Down Right
			aux.x+=2;
			
			try {
				contested = getPositionByCoordinate(aux);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			
			if (contested.occupiedBy != null) {
				if (contested.occupiedBy.getColor() != r.getColor()) {
				// Other player, can eat the piece
					posible = Position.appendPositionToArray(posible, contested);
				}
			}
		}
		
		return posible;	
	}
	
	private Position[] findRookAvailablePositions(Position current) {
		
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
				if (nextXPosition.occupiedBy.getColor() == r.getColor()) {
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
				if (nextXPosition.occupiedBy.getColor() == r.getColor()) {
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
				if (nextYPosition.occupiedBy.getColor() == r.getColor()) {
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
				if (nextYPosition.occupiedBy.getColor() == r.getColor()) {
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
	
	private Position[] findBishopAvailablePositions(Position current) {
		
			Piece r = current.occupiedBy;
			if (r == null) {
				return null;
			}
			
			// Vector of possible positions for a rook (8V - Current)+(8H-Current) = 14
			Position possible[] = new Position[14];
			int i=0;

			Coordinate c = current.coordinate;
			Coordinate aux = new Coordinate(c.x,c.y);
			
			// Check for available positions in Right Upwards diagonal
			while (aux.x<9 && aux.y<9) {
				
				Position nextXPosition;
				try {	
					aux.x++;
					aux.y++;
					// Verify if position is on table, and gets its position if exists
					nextXPosition = this.getPositionByCoordinate(aux);
				} catch (Exception e) {
					// Position doesn't exist on table
					System.out.println("Position Doesnt exist on table");
					break;
				}
				
				if (nextXPosition.occupiedBy != null) {
					if (nextXPosition.occupiedBy.getColor() == r.getColor()) {
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
			
			
			while (aux.x<9 && aux.y>0) {
				
				Position nextXPosition;
				try {
					aux.x++;
					aux.y--;
					nextXPosition = this.getPositionByCoordinate(aux);
				} catch (Exception e) {
					// Position doesn't exist on table
					System.out.println("Position Doesnt exist on table");
					break;
				}
				
				if (nextXPosition.occupiedBy != null) {
					if (nextXPosition.occupiedBy.getColor() == r.getColor()) {
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
			
			while (aux.x>0 && aux.y<9) {
				
				Position nextYPosition;
				
				try {
					aux.x--;
					aux.y++;
					nextYPosition = this.getPositionByCoordinate(aux);
				} catch (Exception e) {
					break;
				}
				
				if (nextYPosition.occupiedBy != null) {
					if (nextYPosition.occupiedBy.getColor() == r.getColor()) {
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
			
			while (aux.x > 0 && aux.y>0) {
				
				Position nextYPosition;
				
				try {
					aux.x--;
					aux.y--;
					nextYPosition = this.getPositionByCoordinate(aux);
				} catch (Exception e) {
					break;
				}
				
				if (nextYPosition.occupiedBy != null) {
					if (nextYPosition.occupiedBy.getColor() == r.getColor()) {
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
 	
	private Position[] findKnightAvailablePositions(Position current) {
		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
		// Vector of possible positions for a knight (2*Each Diagonal) = 8
		Position possible[] = new Position[8];
		int i=0;

		Coordinate c = current.coordinate;
		Coordinate aux = new Coordinate(c.x,c.y);
	
		//TODO: Refactor this logic
		// Verify upper right corner
		Position nextXPosition;
		try {	
			aux.x++;
			aux.y+=2;
			// Verify if position is on table, and gets its position if exists
			nextXPosition = this.getPositionByCoordinate(aux);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.getColor() != r.getColor()) {
					// other player
					possible[i] = nextXPosition;
					i++;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
		} catch (Exception e) {
			// Position doesn't exist on table
			System.out.println("Position Doesnt exist on table");
		}
		
		aux.x = c.x;
		aux.y = c.y;

		try {	
			aux.x+=2;
			aux.y++;
			// Verify if position is on table, and gets its position if exists
			nextXPosition = this.getPositionByCoordinate(aux);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.getColor() != r.getColor()) {
					// other player
					possible[i] = nextXPosition;
					i++;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
		} catch (Exception e) {
			// Position doesn't exist on table
			System.out.println("Position Doesnt exist on table");
		}
		
		aux.x = c.x;
		aux.y = c.y;
		
		// Verify upper left corner
		try {	
			aux.x--;
			aux.y+=2;
			// Verify if position is on table, and gets its position if exists
			nextXPosition = this.getPositionByCoordinate(aux);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.getColor() != r.getColor()) {
					// other player
					possible[i] = nextXPosition;
					i++;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
		} catch (Exception e) {
			// Position doesn't exist on table
			System.out.println("Position Doesnt exist on table");
		}
		
		aux.x = c.x;
		aux.y = c.y;
		
		try {	
			aux.x-=2;
			aux.y++;
			// Verify if position is on table, and gets its position if exists
			nextXPosition = this.getPositionByCoordinate(aux);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.getColor() != r.getColor()) {
					// other player
					possible[i] = nextXPosition;
					i++;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
		} catch (Exception e) {
			// Position doesn't exist on table
			System.out.println("Position Doesnt exist on table");
		}
		
		
		aux.x = c.x;
		aux.y = c.y;
		
		// Verify lower right corner
		try {	
			aux.x++;
			aux.y-=2;
			// Verify if position is on table, and gets its position if exists
			nextXPosition = this.getPositionByCoordinate(aux);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.getColor() != r.getColor()) {
					// other player
					possible[i] = nextXPosition;
					i++;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
		} catch (Exception e) {
			// Position doesn't exist on table
			System.out.println("Position Doesnt exist on table");
		}
		
		aux.x = c.x;
		aux.y = c.y;
		
		try {	
			aux.x+=2;
			aux.y--;
			// Verify if position is on table, and gets its position if exists
			nextXPosition = this.getPositionByCoordinate(aux);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.getColor() != r.getColor()) {
					// other player
					possible[i] = nextXPosition;
					i++;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
		} catch (Exception e) {
			// Position doesn't exist on table
			System.out.println("Position Doesnt exist on table");
		}
		
		aux.x = c.x;
		aux.y = c.y;
		
		// Verify lower left corner
		try {	
			aux.x--;
			aux.y-=2;
			// Verify if position is on table, and gets its position if exists
			nextXPosition = this.getPositionByCoordinate(aux);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.getColor() != r.getColor()) {
					// other player
					possible[i] = nextXPosition;
					i++;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
		} catch (Exception e) {
			// Position doesn't exist on table
			System.out.println("Position Doesnt exist on table");
		}
		
		aux.x = c.x;
		aux.y = c.y;
		
		try {	
			aux.x-=2;
			aux.y--;
			// Verify if position is on table, and gets its position if exists
			nextXPosition = this.getPositionByCoordinate(aux);
			if (nextXPosition.occupiedBy != null) {
				if (nextXPosition.occupiedBy.getColor() != r.getColor()) {
					// other player
					possible[i] = nextXPosition;
					i++;
				}
			} else {
				possible[i] = nextXPosition;
				i++;
			}
		} catch (Exception e) {
			// Position doesn't exist on table
			System.out.println("Position Doesnt exist on table");
		}
		
		return possible;
		
	}

	private Position[] findQueenAvailablePositions(Position current) {
		
		
		Position posible[] = {};
				
		Position bishopPosible[] = findBishopAvailablePositions(current); 
		
		Position rookPosible[] = findRookAvailablePositions(current);
		
		for (int i = 0; i<bishopPosible.length;i++) {
			if (bishopPosible[i] == null) {
				break;
			}
			posible = Position.appendPositionToArray(posible, bishopPosible[i]);
		}
		
		for (int i = 0; i<rookPosible.length;i++) {
			if (rookPosible[i] == null) {
				break;
			}
			posible = Position.appendPositionToArray(posible, rookPosible[i]);
		}
		
		return posible;
	}
	
	private Position[] findKingAvailablePositions(Position current) throws Exception {
		Piece r = current.occupiedBy;
		if (r == null) {
			return null;
		}
		
		Color team = r.getColor();
		Color oponent = r.getColor() == Color.BLACK ? Color.WHITE: Color.BLACK;
		
		Position[] initialPosible = {};
		
		//
		
		
		if (initialPosible.length == 0) {
			// Verify if other pieces can block
			throw new Checkmate();
		}
		
		return initialPosible;
	}

	protected boolean lookForCheck(Player p) {
		
		Color c = p.getColor();
		Color enemyColor = c == Color.WHITE ? Color.BLACK : Color.WHITE;
		
		System.out.println(c+" "+enemyColor);
		
		for (Position pos: this.getAllPositions()) {
			
			Piece pc = pos.occupiedBy;
			if (pc != null && pc.getColor() == enemyColor) {
				System.out.println("Piece Type "+pc.getPieceType());
				Position posible[] = this.findAvailablePositions(pos);
				for (Position posibleCheck: posible) {
					
					if (posibleCheck.occupiedBy != null && posibleCheck.occupiedBy.getPieceType() == PieceType.KING) {
						return true;
					}
				}
			}
		}
		
		
		return false;
	}
}
