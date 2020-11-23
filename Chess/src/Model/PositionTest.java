package Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;

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
		this.p2 = new Position(1,1);
		this.p3 = new Position(2,1);
	}

	@AfterEach
	void tearDown() throws Exception {
		this.p = null;
		this.p2 = null;
		this.p3 = null;
	}

	@Test
	void testPosition() {
		Position ps[] = {};
		ps = Position.appendPositionToArray(ps, p);
		ps = Position.appendPositionToArray(ps, p2);
		ps = Position.appendPositionToArray(ps, p3);
		
		
		for (int i = 0; i<ps.length;i++) {
			if (ps[i] == null) {
				System.out.println("NULL at"+i);
				break;
			}
			System.out.println(ps[i].coordinate.x+" "+ps[i].coordinate.y);
		}
		
		
		assertEquals(ps[0],p);
		assertEquals(this.p.coordinate.x,0);
		assertEquals(this.p.coordinate.y,1);
		assertFalse(Position.checkEqualCoordinate(this.p3, this.p2));
	}

}
