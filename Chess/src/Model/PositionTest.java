package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {

	Position p; 
	
	@BeforeEach
	void setUp() throws Exception {
		this.p = new Position(0,1);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.p = null;
	}

	@Test
	void testPosition() {
		assertEquals(this.p.coordinate.x,1);
		assertEquals(this.p.coordinate.y,1);
		assertEquals(this.p.color,Color.BRANCO);
	}

}
