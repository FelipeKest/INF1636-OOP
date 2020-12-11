package Controller;
import Model.ModelAPI;

public class MenuController {

	
	
	public MenuController() {
		// TODO Auto-generated constructor stub
		
	}

	
	public void startGame(String name1, String name2) {
		ModelAPI m = ModelAPI.getAPIInstance();
		m.startGame(name1, name2);
	}
	
}
