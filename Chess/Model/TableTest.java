package Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;

import Utils.PieceType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest {

	Table t; 
	
	@BeforeEach
	void setUp() throws Exception {
		this.t = Table.getTableInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.t = null;
	}

	void mockTable() {
		for (int i = 0; i<9; i++) {
			for (int j = 1; j<9; j++) {
				if (i == 8 && j == 1) {
					Piece r = new Piece(PieceType.ROOK,Color.WHITE);
					Position p = new Position(i,j,r);
					this.t.notifyPositions(p);
				} else if (i==5 && j == 1) {
					Piece k = new Piece(PieceType.KING,Color.WHITE);
					Position p2 = new Position(i,j,k);
					this.t.notifyPositions(p2);
				} else {
					Position empty = new Position(i,j);
					this.t.notifyPositions(empty);
				}
			}
		}
	}
	
	@Test
	void test() {
		this.mockTable();
		Position[] allPositions = this.t.getAllPositions();
		
		Coordinate c = new Coordinate(8,1);
		Coordinate c2 = new Coordinate(5,4);
		
		Player w = new Player("W",Color.WHITE);
		Player b = new Player("B",Color.BLACK);
		
		Piece k = new Piece(PieceType.KNIGHT,Color.WHITE);
		Piece r = new Piece(PieceType.ROOK,Color.WHITE);
		Piece r2 = new Piece(PieceType.ROOK,Color.BLACK);
		Piece q = new Piece(PieceType.QUEEN,Color.WHITE);
		
		
//		Position pK = new Position(3,3,k);
//		Position pR1 = new Position(1,2,r);
//		Position pR2 = new Position(3,4,r2);
//		Position pB = new Position(2,2,b);
//		Position pQ = new Position(1,1,q);
//		
//		this.t.notifyPositions(pB);
//		this.t.notifyPositions(pR1);
//		this.t.notifyPositions(pQ);
//		
//		
//		Position[] ret1 = t.findBishopAvailablePositions(pB);
//		Position[] ret1 = t.findAvailablePositions(pB);
		Position p;
		Position p2;
		
		try {
			p = t.getPositionByCoordinate(c);
			p2 = t.getPositionByCoordinate(c2);
		} catch (Exception e) {
			System.out.println("Invalid");
			return;
		}
		
		for (int i = 0; i<allPositions.length;i++) {
			if (allPositions[i].occupiedBy != null){
				System.out.println(allPositions[i].coordinate.x+"  "+allPositions[i].coordinate.y);				
			}
		}
		
		Position[] poss = t.findAvailablePositions(p);
		System.out.println(poss.length);
		
		for (int i = 0;poss[i]!=null;i++) {
			System.out.println(poss[i].coordinate.x+"  "+poss[i].coordinate.y);
		}
		
		
		assertEquals(this.t.getAllPositions().length,64);
		try {
			assertEquals(this.t.lookForCheck(Color.WHITE),false);
			assertEquals(this.t.getPositionByCoordinate(c).coordinate.y,1);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.x,5);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.y,4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
