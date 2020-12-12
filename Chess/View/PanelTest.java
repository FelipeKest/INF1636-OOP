package View;
import Model.ModelAPI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PanelTest {
	
	ModelAPI model;
	Panel panel;

	@BeforeEach
	void setUp() throws Exception {
		this.model = ModelAPI.getAPIInstance();
		this.panel = new Panel();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.model = null;
		this.panel = null;
	}

	@Test
	void testIfObeserverIsWorking() {
		model.setupObservers(panel);
		model.movePiece(1, 2, 1, 4);		
	}

}
