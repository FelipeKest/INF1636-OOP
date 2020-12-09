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

	@Test
	void test() {
		Position[] allPositions = t.getAllPositions();
		
		Coordinate c = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(5,4);
		
		Piece k = new Piece(PieceType.KNIGHT,Color.WHITE);
		Piece r = new Piece(PieceType.ROOK,Color.WHITE);
		Piece r2 = new Piece(PieceType.ROOK,Color.BLACK);
		Piece b = new Piece(PieceType.BISHOP,Color.BLACK);
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
		
		for (int i = 0; i<allPositions.length;i++) {
			if (allPositions[i].occupiedBy == null) {
			
			} else {
				System.out.println(allPositions[i].occupiedBy.getPieceType() + "  " + allPositions[i].occupiedBy.getColor());
			}
		}
		
		
		assertEquals(this.t.getAllPositions().length,64);
		try {
//			assertEquals(this.t.getPositionByCoordinate(c).coordinate.x,1);
//			assertEquals(this.t.getPositionByCoordinate(c).coordinate.y,1);
//			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.x,5);
//			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.y,4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
