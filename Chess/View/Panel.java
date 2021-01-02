package View;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Model.*;
import Utils.*;

import java.awt.*;

public class Panel extends JPanel implements PieceObserver {
	
	public static final int TXT_X=120;
	public static final int TXT_Y=140;
	private int[][] visualPositions = new int[64][4];
	private Images piecesImages;
	
	JFrame frame;
	public JButton saveB;
	
	public Panel(MouseListener l, ActionListener a) {
		// Cadastrando o Panel para que possa receber as notificações 
		this.piecesImages = new Images();
		this.setupFrame(l,a);
//		for (int[] visualPosition: visualPositions) {
//			System.out.println("Visual Positions: " + visualPosition[0] + visualPosition[1] + visualPosition[2] + visualPosition[3]);
//		}
	}
	
    private void setupFrame(MouseListener l,ActionListener a)
    {
    	frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(610,700);
        frame.addMouseListener(l);
        frame.setVisible(true);
        
        Container mainP = frame.getContentPane();
        mainP.setLayout(null);
       
        saveB = new JButton("Salvar Jogo");
        mainP.add(saveB);
        saveB.addActionListener(a);
        saveB.setBounds(200, 600, 200, 100);
        
    }
	
    public void saveGame(String data) {
        JFileChooser file;
        file = openFileSelector();
        FileWriter arq = null;
        try {
            arq = new FileWriter( new File(file.getSelectedFile().getPath()+".txt"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        PrintWriter gravarArq = new PrintWriter(arq);
        
        String dataLines[] = data.split(("\\r?\\n"));
		int i = 0;
		
		for (String dataLine: dataLines) {
			String dataChars[] = dataLine.split(",");
			if (i == 0 || i==1) {
				gravarArq.printf("%s,%s\n",dataChars[0], dataChars[1]);
			}  else {
				gravarArq.printf("%s,%s,%s,%s\n",dataChars[0], dataChars[1],dataChars[2], dataChars[3]);
			}
			i++;
		}
       
        try {
            arq.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    
    private JFileChooser openFileSelector() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.setDialogTitle("Save file");
        file.showOpenDialog(null);
        return file;
    }
    
	@Override
	public void paintComponent(Graphics g) {
	super.paintComponent(g);
	// Colocar botao aqui
	
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
	
	@Override
    public void paint(Graphics g)
    {
		System.out.println("chamei");
		super.paint(g);
        displayPieces(g);
    }
	
	public void notifyPositions(PieceObserved observed) {
		this.visualPositions = observed.getVisualPositions();
		this.repaint();		
	}
	
	public void displayPieces(Graphics g) {
		int i = 0;
		for (int[] piece: this.visualPositions) {			
			Image pieceImage = this.getPieceImage(piece[3], piece[2]);
			g.drawImage(pieceImage, getXPosition(piece[0]), getYPosition(piece[1]), null);
			i+=10;
		}
	}
	
	private int getXPosition(int x) {
//      int xDistance = (getWidth()/8);

      int xDistance = (600/8);
      return (xDistance * x) - 75;
  }

  private int getYPosition(int y) {
//      int yDistance = ((getHeight()-100)/8);
      int yDistance = (600/8);

      return (yDistance * y) - 75;
  }
	
	private Image getPieceImage(int color, int type) {
		// Color == Black
		if (color == 1) {
			switch (type) {
			// PAWN
			case 0:
				return this.piecesImages.blackPawn;
			// KING
			case 1:
				return this.piecesImages.blackKing;
				
			// QUEEN
			case 2:
				return this.piecesImages.blackQueen;
				
			// KNIGHT
			case 3:
				return this.piecesImages.blackKnight;
				
			// ROOK
			case 4:
				return this.piecesImages.blackRook;
				
			// BISHOP
			case 5:
				return this.piecesImages.blackBishop;
				
			}
		}
		// Color == White
		else {
			switch (type) {
			// PAWN
			case 0:
				return this.piecesImages.whitePawn;
				
			// KING
			case 1:
				return this.piecesImages.whiteKing;
				
			// QUEEN
			case 2:
				return this.piecesImages.whiteQueen;
				
			// KNIGHT
			case 3:
				return this.piecesImages.whiteKnight;
				
			// ROOK
			case 4:
				return this.piecesImages.whiteRook;
				
			// BISHOP
			case 5:
				return this.piecesImages.whiteBishop;
				
			}
		}
		
		return null;
	}
}
