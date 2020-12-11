package Controller;

import Model.ModelAPI;

public class GameController {

	public GameController() {
		// TODO Auto-generated constructor stub
	}

	
	public void movePiece(int x0,int y0, int xF, int yF) {
		ModelAPI m = ModelAPI.getAPIInstance();
		m.movePiece(x0, y0, xF, yF);
	}
}
