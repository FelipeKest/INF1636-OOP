package View;

import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame {
	public final int LARG_DEFAULT=400;
	public final int ALT_DEFAULT=300;
	
	
	public Frame(String s) {
		super(s);
		this.setSize(700,700);
		this.getContentPane().add(new Panel());
		this.setLocationRelativeTo(null);
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		Frame f= new Frame("Exemplo JPanel");
		f.setVisible(true);
	}
}
