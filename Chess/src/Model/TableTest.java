package Model;

import static org.junit.jupiter.api.Assertions.*;

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
		Coordinate c = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(5,4);
		Rook r = new Rook(Color.BRANCO);
		Rook r2 = new Rook(Color.PRETO);
		Bishop b = new Bishop(Color.PRETO);
		Position p = new Position(4,3,b);
		// TODO: Check if rooks are on the same team
		Position p1 = new Position(5,4,r);
		Position p2 = new Position(3,4,r2);
		this.t.changePositions(p);
		this.t.changePositions(p1);
		this.t.changePositions(p2);
		Position[] ret = t.findBishopAvailablePositions(p);

		for (int i = 0; ret[i] != null;i++) { 
			System.out.println(ret[i].coordinate.x+" "+ret[i].coordinate.y);
		}
		assertEquals(this.t.getAllPositions().length,64);
		try {
			assertEquals(this.t.getPositionByCoordinate(c).coordinate.x,1);
			assertEquals(this.t.getPositionByCoordinate(c).coordinate.y,1);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.x,5);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.y,4);
//			assertFalse(this.t.getPositionByCoordinate(c2).occupiedBy,null);
			assertNotEquals(this.t.getPositionByCoordinate(c2).occupiedBy,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
