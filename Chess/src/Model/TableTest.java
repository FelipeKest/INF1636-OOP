package Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableTest {

	Table t; 
	
	@BeforeEach
	void setUp() throws Exception {
		this.t = new Table();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.t = null;
	}

	@Test
	void test() {
		assertEquals(this.t.positions.length,64);
		assertEquals(this.t.positions[0].coordinate.x,1);
		assertEquals(this.t.positions[0].coordinate.y,1);
		assertEquals(this.t.positions[63].coordinate.x,8);
		assertEquals(this.t.positions[63].coordinate.y,8);
	}

}
