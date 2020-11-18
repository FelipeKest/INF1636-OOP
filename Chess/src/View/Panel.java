package View;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

	public static final int TXT_X=120;
	public static final int TXT_Y=140;
	
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
		g.drawString("Primeiro Programa Gráfico",TXT_X,TXT_Y);
	}


}
