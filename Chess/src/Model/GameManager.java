package Model;
//import java.sql.Time;

import Model.Color;
import Model.GameManager;
import Model.Piece;
import Model.Player;
import Model.Table;

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
	
    protected void killPiece(Piece piece){
        piece.isAlive = false;
    }
    protected void ressurectPiece(Piece piece){
        piece.isAlive = true;
    }
    protected void pause() {
        //drop warning
        //freeze movements
        //stop timer
//    	timer.wait();
    }
    
    protected String[] getPlayersName(){
    	String names[] = new String[2];
    	names[0] = this.player1.getPlayerName();
    	names[1] = this.player2.getPlayerName();
        return names;
    }

    public void createPlayers(String name1, String name2, Color color1, Color color2) {
    	this.player1 = new Player(name1, color1);
    	this.player2 = new Player(name2, color2);
    }
    protected void startGame(String playerName1, String playerName2){
    	int sort = (int)(Math.random()*10);
    	if(sort%2 == 0) {
    		createPlayers(playerName1, playerName2, Color.WHITE, Color.BLACK); 	
    	}
    	else {
    		createPlayers(playerName1, playerName2, Color.BLACK, Color.WHITE); 
    	}
    }
    
    
}