package View;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

	public static final int TXT_X=120;
	public static final int TXT_Y=140;
	
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
		g.fillRect(50,50,600,600);
		for (int x = 50;x<=600;x+=150) {
			for (int y = 50;y<=600;y+=150) {
				g.clearRect(x, y, 75, 75);
			}
		}
		
		for (int x = 125;x<=600;x+=150) {
			for (int y = 125;y<=600;y+=150) {
				g.clearRect(x, y, 75, 75);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Frame f = new Frame("Chess");
	}


}
