package View;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import java.awt.event.*;


class RessurectMenu {
	
	 public RessurectMenu(){  
         final JFrame f= new JFrame("Resurect Example");  
         final JPopupMenu popupmenu = new JPopupMenu("Edit");   
         JMenuItem queenItem = new JMenuItem("Rainha");  
         JMenuItem pawnItem = new JMenuItem("Peao");  
         JMenuItem rookItem = new JMenuItem("Torre");
         JMenuItem knightItem = new JMenuItem("Cavalo");
         JMenuItem bishopItem = new JMenuItem("Bispo");
         popupmenu.add(queenItem); 
         popupmenu.add(pawnItem); 
         popupmenu.add(rookItem);
         popupmenu.add(knightItem);
         popupmenu.add(bishopItem);
         
         f.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {              
                popupmenu.show(f , e.getX(), e.getY());  
            }                 
         });
         
         f.add(popupmenu);   
         f.setSize(300,300);  
         f.setLayout(null);  
         f.setVisible(true);  
     } 

}