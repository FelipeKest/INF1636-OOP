package Model;

import java.sql.*;
//import java.sql.Time;

public class GameManager{
//	private Player player1;
//    private Player player2;
//    private Round currentRound;
    private Table gameTable;
//    public Time timer;
	
    public void killPiece(Piece piece){
        piece.isAlive = false;
    }
    public void ressurectPiece(Piece piece){
        piece.isAlive = true;
    }
    public void pause() {
        //drop warning
        //freeze movements
        //stop timer
//        timer.wait();
    }
    public String getPlayerName(){
        String name;
        // get string from interface
        return name;
    }


    public void createPlayer(Player player, String name, Color color){
        player.name = name;
        player.color = color;
    }
    public void startGame(String playerName1, String playerName2){
//        createPlayer(player1, playerName1, white);
//        createPlayer(player2, playerName2, black); 

    }
}