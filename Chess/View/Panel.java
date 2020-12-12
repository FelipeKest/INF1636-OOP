package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.*;
import Utils.*;

import java.awt.*;

public class Panel extends JPanel implements PieceObserver {
	
	public static final int TXT_X=120;
	public static final int TXT_Y=140;
	
	JFrame frame;
	
	public Panel(MouseListener l) {
		// Cadastrando o Panel para que possa receber as notificações 
		ModelAPI.getAPIInstance().registerObserver(this);
		this.setupFrame(l);
	}
	
	@Override
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
		g.fillRect(0,0,600,600);
		for (int x = 0;x<600;x+=150) {
			for (int y = 0;y<600;y+=150) {
				g.clearRect(x, y, 75, 75);
			}
		}
		
		for (int x = 75;x<600;x+=150) {
			for (int y = 75;y<600;y+=150) {
				g.clearRect(x, y, 75, 75);
			}
		}
	}
	
	public void notifyPositions(PieceObserved observed) {
		observed.getVisualPositions();
		// utilizar o getPositions para desenhar o tabuleiro
	}
	
	public void startDraw() {
		Frame f = new Frame("Chess");	
	}
	
    private void setupFrame(MouseListener l)
    {
    	frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(600,620);
        frame.addMouseListener(l);
        frame.setVisible(true);
    }
}
