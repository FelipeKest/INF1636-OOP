package Model;

public final class ModelAPI {

	public static ModelAPI ModelAPI;
	private GameManager GM;
	
	private ModelAPI() {
		this.GM = GameManager.getGameManagerInstance();
	}
	

	protected static ModelAPI getAPIInstance() {
		if (ModelAPI == null) {
			ModelAPI = new ModelAPI();
		}
		return ModelAPI;
	}
}
