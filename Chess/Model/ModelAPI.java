package Model;

import Utils.PieceObserver;

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
	
	public void startGame(String name1, String name2) {
		GM.startGame(name1, name2);
	}
	
	public void movePiece(int x0, int y0, int xF, int yF) {
		
	}
	
	public int[][] getPossiblePositions(int posX,int posY) {
		return GM.getAvailablePositions(posX, posY);
	}
	
	public void registerObserver(PieceObserver observer) {
		GM.getGameManagerInstance().getTable().add(observer);
	}
}
