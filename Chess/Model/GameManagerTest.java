package Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameManagerTest {

	GameManager GM;
	
	@BeforeEach
	void setUp() throws Exception {
		this.GM = GameManager.getGameManagerInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.GM = null;
	}

	@Test
	void test() {
		GM.startGame("Joao", "Nino");
		assertEquals(GM.getPlayersNames()[0],"Joao");
		assertEquals(GM.getPlayersNames()[1],"Nino");
		assertNotEquals(GM.getPlayersColors()[0],null);
		assertNotEquals(GM.getPlayersColors()[1],null);
	}

}
