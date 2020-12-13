package View;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class MenuView extends JFrame {
	
	
	private JLabel titleL, nameL1, nameL2;
    private JButton startB, loadB, exitB;
    private JTextField nameTF1, nameTF2;

    static JFrame frame1 = new JFrame("Menu de Jogadores");

    public MenuView(ActionListener[] actionListeners) {
    	setupView();
    	startB.addActionListener(actionListeners[0]);
    	loadB.addActionListener(actionListeners[1]);
    	exitB.addActionListener(actionListeners[2]);
    }

    private void setupView() {
        frame1.setSize(500,450);

        Container mainP = frame1.getContentPane();
        mainP.setLayout(null);

        titleL = new JLabel("Xadrez");
        nameL1 = new JLabel("Jogador 1");
        nameL2 = new JLabel("Jogador 2"); 
        nameTF1 = new JTextField();
        nameTF2 = new JTextField();
        startB = new JButton("Iniciar");
        loadB = new JButton("Carregar jogo");
        exitB = new JButton("Sair");
        
        int currentHeight = 30;
        
        mainP.add(titleL);
        titleL.setFont(new Font("Arial",Font.BOLD,20));
        titleL.setBounds(200, currentHeight, 200, 50);

        currentHeight+=60;
        
        mainP.add(nameL1);
        nameL1.setFont(new Font("Arial",Font.BOLD,15));
        nameL1.setBounds(200, currentHeight, 100, 15);
      
        currentHeight+=20;
        
        mainP.add(nameTF1);
        nameTF1.setBounds(200, currentHeight, 100, 20);
        
        currentHeight+=30;
        
        mainP.add(nameL2);
        nameL2.setFont(new Font("Arial",Font.BOLD,15));
        nameL2.setBounds(200, currentHeight, 100, 15);
        
        currentHeight+=20;

        mainP.add(nameTF2);
        nameTF2.setBounds(200, currentHeight, 100, 20);

        currentHeight+=30;
        
        mainP.add(startB);
        startB.setBounds(200, currentHeight, 100, 20);

        currentHeight+=30;
        
        mainP.add(loadB);
        loadB.setBounds(150, currentHeight, 200, 20);

        currentHeight+=30;

        mainP.add(exitB);
        exitB.setBounds(200, currentHeight, 100, 20);

        frame1.setVisible(true);
        frame1.setResizable(false);
    }
	
}
