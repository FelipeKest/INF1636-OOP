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
		
		Position p0 = GM.getTable().getPositionByCoordinate(c0);
		Position pF = GM.getTable().getPositionByCoordinate(cF);
		
		Piece p = null;
		if (p0.occupiedBy != null) {
			p = p0.occupiedBy;
		}
		
		p0.occupiedBy = null;
		pF.occupiedBy = p;
		
		GM.getTable().notifyPositions(p0);
		GM.getTable().notifyPositions(pF);
		
		for (int[] position: this.getVisualPositions()) {
			System.out.println("visual: " + position[0] + " " + position[1] + " " + position[2] + " " + position[3] + " ");
		}
	}
	
	public void ressurectPiece(int x0, int y0, PieceType newType) {
		Coordinate c0 = new Coordinate(x0,y0);
		GM.ressurectPieceAt(c0, newType);
	}
	
	public boolean isPositionInPieceAvailableMoves(int oldPosX, int oldPosY, int newPosX, int newPosY) {
		boolean isPositionInPieceAvailableMoves = false;
		Coordinate oldCoordinate = new Coordinate(oldPosX, oldPosY);
		Coordinate newCoordinate = new Coordinate(newPosX, newPosY);
		
		Position oldPosition = GM.getTable().getPositionByCoordinate(oldCoordinate);
		Position newPosition = GM.getTable().getPositionByCoordinate(newCoordinate);
		
		Position[] availableMoves = GM.getTable().findAvailablePositions(oldPosition);
		
		if (availableMoves == null) {
			return false;
		}
		
		for (Position availablePosition: availableMoves) {
			if (availablePosition != null) {
				System.out.println("availablePosition: " + availablePosition.coordinate.x);
				if (availablePosition.coordinate.x == newPosition.coordinate.x) {
					if (availablePosition.coordinate.y == newPosition.coordinate.y) {
						isPositionInPieceAvailableMoves = true;
					} 
				}
			}
		}
		
		System.out.println("available: " + isPositionInPieceAvailableMoves);

		return isPositionInPieceAvailableMoves;
	}
	
	public int[][] getPossiblePositions(int posX,int posY) {
		return GM.getAvailablePositions(posX, posY);
	}
	
	public int[][] getVisualPositions() {
		return GM.getTable().getVisualPositions();
	}
	
	public boolean isPositionOccupied(int posX, int posY) {
		Coordinate pos = new Coordinate(posX,posY);
		boolean isOccupied = false;
		if (GM.getTable().getPositionByCoordinate(pos).occupiedBy != null) {
			isOccupied = true;
		}
		return isOccupied;
	}
		
	public void registerObserver(PieceObserver observer) {
		System.out.println("registerObserver");
		GM.getTable().add(observer);
		GM.getTable().alertObservers();
	}
	
	public String saveGameData() { 
		return GM.saveGameToFile();
	}
	
	public void loadGameData(String data) {
		GM.loadGameFromFile(data);
	}
	
	public int getPieceOwner(int posX, int posY) {
		Coordinate pos = new Coordinate(posX,posY);
		return GM.getTable().getPositionByCoordinate(pos).occupiedBy.getColor().ordinal();
	}
	
	public int getPlayerRound() {
    	return GM.getPlayerRound();
    }
    
	public void increaseRound() {
    	GM.increaseRound();
    }
	
}
