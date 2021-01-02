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
		for (int i = 1; i<9; i++) {
			for (int j = 1; j<9; j++) {
				if (i == 1 && j == 1) {
					Piece pwn1 = new Piece(PieceType.KING,Color.WHITE);
					Position p = new Position(i,j,pwn1);
					this.t.notifyPositions(p);
				} else if (i==1 && j == 3) {
					Piece pwn2 = new Piece(PieceType.PAWN,Color.BLACK);
					Position p2 = new Position(i,j,pwn2);
					this.t.notifyPositions(p2);
				} else if (i==3 && j == 1) {
					Piece k = new Piece(PieceType.PAWN,Color.BLACK);
					Position p2 = new Position(i,j,k);
					this.t.notifyPositions(p2);
				} else {
					Position empty = new Position(i,j);
					this.t.notifyPositions(empty);
				}
			}
		}
		for (int i = 1; i<9; i++) {
			for (int j = 1; j<9; j++) {
				Coordinate c = new Coordinate(i,j);
				Position p = this.t.getPositionByCoordinate(c);
				if (p.occupiedBy != null) {
					System.out.println(p.coordinate.x + " " + p.coordinate.y);
				}
			}
		}
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
	}
	
	@Test
	void test() {
		this.mockTable();
		Position[] allPositions = this.t.getAllPositions();
		
		Coordinate c = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(1,3);
		
		Player w = new Player("W",Color.WHITE);
		Player b = new Player("B",Color.BLACK);
		
		Piece k = new Piece(PieceType.KNIGHT,Color.WHITE);
		Piece r = new Piece(PieceType.ROOK,Color.WHITE);
		Piece r2 = new Piece(PieceType.ROOK,Color.BLACK);
		Piece q = new Piece(PieceType.QUEEN,Color.WHITE);
		
		Position p;
		Position p2;
		
		try {
			p = t.getPositionByCoordinate(c);
			p2 = t.getPositionByCoordinate(c2);
		} catch (Exception e) {
			System.out.println("Invalid");
			return;
		}
		
//		for (int i = 0; i<allPositions.length;i++) {
//			if (allPositions[i].occupiedBy != null){
//				System.out.println(allPositions[i].coordinate.x+"  "+allPositions[i].coordinate.y);				
//			}
//		}
		
		Position[] poss = t.findAvailablePositions(p);
		
//		System.out.println(poss.length);
		
		for (int i = 0;i<poss.length;i++) {
			if (poss[i]!=null) {
				System.out.println("POSIBLE " + poss[i].coordinate.x+"  "+poss[i].coordinate.y);
			}
		}
		
		
		assertEquals(this.t.getAllPositions().length,64);
		try {
			assertEquals(this.t.lookForCheck(Color.WHITE),false);
			assertEquals(this.t.getPositionByCoordinate(c).coordinate.y,7);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.x,6);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.y,6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test
//	void testDataLoader() {
//		this.mockTable();
//		assertNotEquals(t.generateStringFromTable(),"");
//		String dataString = t.generateStringFromTable();
//		Table t2 = t;
//		t.loadTableFromString(dataString);
//		for (int i = 0;i<t2.getAllPositions().length;i++) {
//			int[] intP1 = t.getAllPositions()[i].mapToInt();
//			int[] intP2 = t2.getAllPositions()[i].mapToInt();
//			for (int j = 0; j<intP2.length;j++) {
//				assertEquals(intP1[j],intP2[j]);
//			}
//		}
//		
//	}

}
