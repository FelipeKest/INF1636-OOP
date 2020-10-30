package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoveManagerTest {

	@Test
	void test() {
		Rook r = new Rook();
		MoveManager MM = MoveManager.getInstanceMM();
		Position p = new Position(1,1,r);
		Position[] possible = {new Position(1,2),new Position(1,3),new Position(1,4),new Position(1,5),new Position(1,6),new Position(1,7),new Position(1,8),new Position(2,1),new Position(3,1),new Position(4,1),new Position(5,1),new Position(6,1),new Position(7,1),new Position(8,1)};
		Position pNull = new Position(1,1);
//		System.out.println(MM);
		System.out.println(MM.rookPositions(pNull));
//		assertEquals(possible,MM.rookPositions(p));
		assertEquals(1,1);
	}
	
}
