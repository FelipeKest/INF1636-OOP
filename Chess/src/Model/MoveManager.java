package Model;

final class MoveManager {
	
	protected static MoveManager MM;
	
	private MoveManager() {
		
	}
	
//	Position[] possiblePositions(Position origin) {
//		Position[] destinies;
//		destinies[0] = new Position(0,1);
//		
//		return destinies;
//	}
	
	private Position[] rookPositions(Position current) {
		Position possible[] = new Position[14];
		
		for (int i = 1; i<9; i++) {
			
		}
		
		
		return possible;
	}
	
	
	public static MoveManager getInstance() {
        if (MM == null) {
            MM = new MoveManager();
        }
        return MM;
    }
	
}
