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
		Coordinate c2 = new Coordinate(4,5);
		Rook r = new Rook(Color.BRANCO);
		Rook r2 = new Rook(Color.PRETO);
		Position p = new Position(4,3,r);
		// TODO: Check if rooks are on the same team
		Position p1 = new Position (4,5,r);
		Position[] possible = {new Position(1,2),new Position(1,3),new Position(1,4),new Position(1,5),new Position(1,6),new Position(1,7),new Position(1,8),new Position(1,1),new Position(3,1),new Position(4,1),new Position(5,1),new Position(6,1),new Position(7,1),new Position(8,1)};
		this.t.changePositions(p);
		this.t.changePositions(p1);
		Position[] ret = t.findRookAvailablePositions(p);

		for (int i = 0; ret[i] != null;i++) { 
			System.out.println(ret[i].coordinate.x+" "+ret[i].coordinate.y);
		}
		assertEquals(this.t.getAllPositions().length,64);
		try {
			assertEquals(this.t.getPositionByCoordinate(c).coordinate.x,1);
			assertEquals(this.t.getPositionByCoordinate(c).coordinate.y,1);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.x,4);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.y,5);
//			assertFalse(this.t.getPositionByCoordinate(c2).occupiedBy,null);
			assertNotEquals(this.t.getPositionByCoordinate(c2).occupiedBy,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
