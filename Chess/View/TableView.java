package View;

import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;

//import Model.GameManager;

public class TableView implements ActionListener {
    private JButton saveBtn = new JButton("Save game");

    public void saveButton(Frame frame) {
//        frame.getContentPane().add(new Panel());
        saveBtn.setBounds(0, 0, 100, 000);
        frame.getContentPane().add(saveBtn);
        saveBtn.addActionListener(this);
    } 

    public void actionPerformed(ActionEvent e) {
        saveGame();
        return;
    }

    public void saveGame() {
        JFileChooser file;
        file = openFileSelector();
        FileWriter arq = null;
        try {
            arq = new FileWriter( new File(file.getSelectedFile().getPath()+".txt"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        PrintWriter gravarArq = new PrintWriter(arq);

//MUDAR AQUI
        gravarArq.printf("Nome1 Cor1\n" + 
                "Nome2 Cor2\n" + 
                "Rodada\n" + 
                "Info da tabela....");
        try {
            arq.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public JFileChooser openFileSelector() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.setDialogTitle("Save file");
        file.showOpenDialog(null);
        return file;
    }
}