package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.ModelAPI;
import View.*;


public class GameController {
	
	protected Panel board;

	public GameController() {
		board = new Panel(this.getMouse(),this.saveActionListener());
	}
	
	public static void movePiece(int x0,int y0, int xF, int yF) {
		ModelAPI m = ModelAPI.getAPIInstance();
		m.movePiece(x0, y0, xF, yF);
		m.increaseRound();
	}
	
	public ActionListener saveActionListener() {
		
		ActionListener actionListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ModelAPI m = ModelAPI.getAPIInstance();
				String data = m.saveGameData();
				
				board.saveGame(data);
			}
			
		};
		
		return actionListener;
		
	}
	
	
    public MouseListener getMouse() {
    	
    	MouseListener mouseListener = new MouseListener() {
    		
    		protected boolean isPieceSelected = false;
    		protected int oldPosX;
    		protected int oldPosY;

			@Override
			public void mouseClicked(MouseEvent e) { 
				int newPosX = translateXPosition(e.getX());
				int newPosY = translateYPosition(e.getY());
				System.out.println("CLICOU        ");
				System.out.println("coord x: " + e.getX());
				System.out.println(" coord y: " + e.getY());
//				System.out.println("is occupiedby: " + ModelAPI.getAPIInstance().isPositionOccupied(newPosX, newPosY));	
				
				if (ModelAPI.getAPIInstance().isPositionOccupied(newPosX, newPosY)) {
					if (ModelAPI.getAPIInstance().getPieceOwner(newPosX, newPosY) == ModelAPI.getAPIInstance().getPlayerRound()) {
						this.isPieceSelected = true;
						this.oldPosX = newPosX;
						this.oldPosY = newPosY;
					}
				} 
				if (this.isPieceSelected == true) {
					boolean isPositionInPieceAvailableMoves = ModelAPI.getAPIInstance().isPositionInPieceAvailableMoves(
							oldPosX,
							oldPosY,
							newPosX,
							newPosY
							);
					if (isPositionInPieceAvailableMoves == true) {
						GameController.movePiece(oldPosX, oldPosY, newPosX, newPosY);
						this.oldPosX = 0;
						this.oldPosY = 0;
						isPieceSelected = false;
					}
				}
			}
//
			@Override
			public void mousePressed(MouseEvent e) { }

			@Override
			public void mouseReleased(MouseEvent e) { }

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse entrou");
			}

			@Override
			public void mouseExited(MouseEvent e) { }
    		
    	};
    	
		return mouseListener;
    }
    
    public int translateXPosition(int value) {
    	int translatedXPosition = (int) (8 * value)/(600);
    	return translatedXPosition + 1;
    }
    
    public int translateYPosition(int value) {
    	int translatedYPosition = (int) ((8 * value)/(600));
    	return translatedYPosition;
    }
}