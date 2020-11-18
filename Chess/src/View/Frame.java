package View;

import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame {
	public final int LARG_DEFAULT=400;
	public final int ALT_DEFAULT=300;
	
	
	public Frame(String s) {
		super(s);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new Panel());
	}
	
	
	
	public static void main(String[] args) {
		Frame f= new Frame("Exemplo JPanel");
		f.setVisible(true);
	}
}
