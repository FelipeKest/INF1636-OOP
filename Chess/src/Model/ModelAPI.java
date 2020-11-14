package Model;

public final class ModelAPI {

	public static ModelAPI ModelAPI;
	private GameManager GM;
	
	private ModelAPI() {
		this.GM = GameManager.getGameManagerInstance();
	}
	

	public static ModelAPI getAPIInstance() {
		if (ModelAPI == null) {
			ModelAPI = new ModelAPI();
		}
		return ModelAPI;
	}
	
	public String[] getPlayersNames() {
		return GM.getPlayersNames();
	}
	
	public void createPlayers(String name1, String name2) {
		
	}
	
	
}
