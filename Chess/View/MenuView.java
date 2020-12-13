package View;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class MenuView extends JFrame implements ActionListener {
	
	
	private JLabel titleL;
    private JButton startB, loadB, exitB;

    static JFrame frame1 = new JFrame();

    public MenuView() {
        frame1.setSize(500,250);

        Container mainP = frame1.getContentPane();
        mainP.setLayout(null);

        titleL = new JLabel("WELCOME");
        startB = new JButton("Iniciar");
        loadB = new JButton("Carregar jogo");
        exitB = new JButton("Sair");


        mainP.add(titleL);
        titleL.setFont(new Font("Arial",Font.BOLD,20));
        titleL.setBounds(100, 30, 200, 50);

        mainP.add(startB);
        startB.setMnemonic(KeyEvent.VK_S);
        startB.setBounds(200, 80, 100, 20);

        mainP.add(loadB);
        loadB.setMnemonic(KeyEvent.VK_H);
        loadB.setBounds(150, 100, 200, 20);


        mainP.add(exitB);
        exitB.setMnemonic(KeyEvent.VK_E);
        exitB.setBounds(200, 120, 100, 20);


        startB.addActionListener(this);
        loadB.addActionListener(this);
        exitB.addActionListener(this);

        frame1.setVisible(true);
        frame1.setResizable(false);

        System.out.println("dwada");
    }



    public static void main(String[]args)
    {
        new MenuView();
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
