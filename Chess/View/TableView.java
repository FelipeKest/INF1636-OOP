package View;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TableView extends JFrame {

    JButton saveBtn = new JButton("Salvar");
    
	public TableView(ActionListener action){
		saveButton(action);
	}

    public void setupSaveButton(ActionListener action){
        this.add(saveBtn);
        saveBtn.setLocation(100,100);
      	saveBtn.setSize(75, 75);
      	saveBtn.setVisible(true);
        saveBtn.addActionListener(action);
    }	

}

