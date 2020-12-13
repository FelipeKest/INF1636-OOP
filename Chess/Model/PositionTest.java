package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Position;

class PositionTest {

	
	@Test
	void test() {
		String x = "1";
		String y = "1";
		String pt = "1";
		String color = "0";
		Position p = Position.stringToPos(x, y, pt, color);
		assertEquals(p.mapToInt()[0],1);
		assertEquals(p.mapToInt()[1],1);
		assertEquals(p.mapToInt()[2],1);
		assertEquals(p.mapToInt()[3],0);
		
		String x2 = "1";
		String y2 = "1";
		String pt2 = "-1";
		String color2 = "-1";
		Position p2 = Position.stringToPos(x, y, pt2, color2);
		assertEquals(p2.mapToInt()[0],1);
		assertEquals(p2.mapToInt()[1],1);
		assertEquals(p2.mapToInt()[2],-1);
		assertEquals(p2.mapToInt()[3],-1);
	}

}
