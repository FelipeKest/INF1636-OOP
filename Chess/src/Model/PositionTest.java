package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {

	Position p;
	Position p2;
	Position p3;
	
	@BeforeEach
	void setUp() throws Exception {
		this.p = new Position(0,1);
		this.p2 = new Position(0,1);
		this.p3 = new Position(1,1);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.p = null;
		this.p2 = null;
		this.p3 = null;
	}

	@Test
	void testPosition() {
		assertEquals(this.p.coordinate.x,0);
		assertEquals(this.p.coordinate.y,1);
		assertTrue(Position.checkEqualCoordinate(this.p, this.p2));
		assertFalse(Position.checkEqualCoordinate(this.p3, this.p2));
		assertEquals(this.p.color,Color.BRANCO);
	}

}
