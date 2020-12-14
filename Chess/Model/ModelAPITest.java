package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelAPITest {

	ModelAPI model;
	
	@BeforeEach
	void setUp() throws Exception {
		this.model = ModelAPI.getAPIInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.model = null;
	}

	@Test
	void test() {
		assertNotEquals(this.model,null);
		this.model.movePiece(1, 2, 1, 4);
		Coordinate c = new Coordinate(1,4);
		Coordinate c2 = new Coordinate(1,2);
		
		Object occ = null;
		Object occ2 = null;
	
		try {
			occ = this.model.GM.getTable().getPositionByCoordinate(c).occupiedBy;
			occ2 = this.model.GM.getTable().getPositionByCoordinate(c2).occupiedBy;
		} catch (Exception e) {
			return;
		}
		
		assertNotEquals(occ,null);
		assertEquals(occ2,null);
	}

}
