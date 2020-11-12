package Model;

final class Player {
	
	private String name;
	private Color color;
	private Position[] deadPieces;
	private Position[] livePieces;
	
	public Player(String name, Color color) {
		// TODO Auto-generated constructor stub
		
		this.name = name;
		this.color = color;
		
		this.deadPieces = null;
		this.livePieces = null;		
		
	}
	
	protected String getPlayerName() {
        return this.name;
    }	

}
