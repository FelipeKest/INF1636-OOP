package Model;
//import java.sql.Time;

public class GameManager{
	private Player player1;
    private Player player2;
//    private Round currentRound;
    private Table gameTable;
//    public Time timer;
    protected static GameManager manager;

    protected static GameManager getGameManagerInstance() {
        if (manager == null) {
            manager = new GameManager();
            manager.gameTable = Table.getTableInstance();
        }
        return manager;
    }    
	
    protected void killPieceAt(Position pos, Piece killer){
    	Piece p = pos.occupiedBy;
    	if (p == null || killer == null) {
    		return;
    	}
        p.isAlive = false;
        pos.occupiedBy = killer;
        gameTable.updatePositions(pos);
    }
    
    protected void ressurectPieceAt(Position pos, Piece newPiece){
    	Piece p = pos.occupiedBy;

    	if (p == null) {
    		return;
    	}
    	
    	newPiece.isAlive = true;
    	p.isAlive = false;
    	pos.occupiedBy = newPiece;
        gameTable.updatePositions(pos);
    }
    protected void pause() {
        //drop warning
        //freeze movements
        //stop timer
//    	timer.wait();
    }
    
    protected String[] getPlayersNames(){
    	String names[] = new String[2];
    	names[0] = this.player1.getName();
    	names[1] = this.player2.getName();
        return names;
    }
    
    protected Color[] getPlayersColors(){
    	Color colors[] = new Color[2];
    	colors[0] = this.player1.getColor();
    	colors[1] = this.player2.getColor();
        return colors;
    }

    private void createPlayers(String name1, String name2) {
    	int sort = (int)(Math.random()*10);
    	if(sort%2 == 0) {
    		this.player1 = new Player(name1, Color.WHITE);
    		this.player2 = new Player(name2, Color.BLACK);
    	} else {
    		this.player1 = new Player(name1, Color.BLACK);
    		this.player2 = new Player(name2, Color.WHITE);
    	}
    }
    
    protected void startGame(String playerName1, String playerName2){
    	manager.createPlayers(playerName1,playerName2);
    }
    
}