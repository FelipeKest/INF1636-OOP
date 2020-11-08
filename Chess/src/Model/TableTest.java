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
		Coordinate c2 = new Coordinate(8,8);
		assertEquals(this.t.getAllPositions().length,64);
		try {
			assertEquals(this.t.getPositionByCoordinate(c).coordinate.x,1);
			assertEquals(this.t.getPositionByCoordinate(c).coordinate.y,1);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.x,8);
			assertEquals(this.t.getPositionByCoordinate(c2).coordinate.y,8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
