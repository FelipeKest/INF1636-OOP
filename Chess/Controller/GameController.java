package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.ModuleLayer.Controller;

import Model.ModelAPI;
import View.*;


public class GameController {
	
	protected Panel board;
	protected ModelAPI model = ModelAPI.getAPIInstance();
//	protected static GameController controller;

	public GameController() {
		board = new Panel(this.getMouse());
	}

    public static void main(String[] args) throws InterruptedException
    {
    	GameController controller = new GameController();
    	controller.model.registerObserver(controller.board);
    }
	
	public void movePiece(int x0,int y0, int xF, int yF) {
		ModelAPI m = ModelAPI.getAPIInstance();
		m.movePiece(x0, y0, xF, yF);
		
	}
	
    public MouseListener getMouse() {
    	
    	MouseListener mouseListener = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) { 
				System.out.println("coord x: " + translateXPosition(e.getX()));
				System.out.println("coord y: " + translateYPosition(e.getY()));
			}

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
    	int translatedXPosition = (int) (8 * value)/this.board.getWidth();
    	return translatedXPosition + 1;
    }
    
    public int translateYPosition(int value) {
    	int translatedYPosition =  8 - (int) ((8 * value)/this.board.getHeight());
    	return translatedYPosition;
    }
}