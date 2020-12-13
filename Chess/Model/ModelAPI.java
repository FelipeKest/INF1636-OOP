package Model;

import Utils.PieceObserver;
import Utils.PieceType;

public final class ModelAPI {

	public static ModelAPI ModelAPI;
	protected GameManager GM;
	
	private ModelAPI() {
		this.GM = GameManager.getGameManagerInstance();
	}

	public static ModelAPI getAPIInstance() {
		if (ModelAPI == null) {
			ModelAPI = new ModelAPI();
		}
		return ModelAPI;
	}
	
	public void setupObservers(PieceObserver observer) {
		this.GM.getTable().add(observer);
	}
	
	public void startGame(String name1, String name2) {
		GM.startGame(name1, name2);
	}
	
	public String[] getPlayersNames() {
		return GM.getPlayersNames();
	}
	
	public void movePiece(int x0, int y0, int xF, int yF) {
		Coordinate c0 = new Coordinate(x0,y0);
		Coordinate cF = new Coordinate(xF,yF);
		
		GM.getTable().movePiece(c0,cF);
	}
	
	public void ressurectPiece(int x0, int y0, PieceType newType) {
		Coordinate c0 = new Coordinate(x0,y0);
		GM.ressurectPieceAt(c0, newType);
	}
	
	public int[][] getPossiblePositions(int posX,int posY) {
		return GM.getAvailablePositions(posX, posY);
	}
	
	public int[][] getVisualPositions() {
		return GM.getTable().getVisualPositions();
	}
	
	public void registerObserver(PieceObserver observer) {
		System.out.println("registerObserver");
		GM.getTable().add(observer);
		GM.getTable().alertObservers();
	}
	
	public String saveGameData() { 
		return GM.getTable().generateStringFromTable();
	}
}
