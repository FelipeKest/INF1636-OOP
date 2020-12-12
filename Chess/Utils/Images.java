package Utils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {
	
	public BufferedImage whitePawn;
	public BufferedImage whiteKing;
	public BufferedImage whiteQueen;
	public BufferedImage whiteKnight;
	public BufferedImage whiteRook;
	public BufferedImage whiteBishop;
	public BufferedImage blackPawn;
	public BufferedImage blackKing;
	public BufferedImage blackQueen;
	public BufferedImage blackKnight;
	public BufferedImage blackRook;
	public BufferedImage blackBishop;
	
	public Images() {
		
		//MARK: - White Pieces 
		
		try {
			whitePawn = ImageIO.read(new File("PieceImages/CyanP.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whiteKing = ImageIO.read(new File("PieceImages/CyanK.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whiteQueen = ImageIO.read(new File("PieceImages/CyanQ.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whiteKnight = ImageIO.read(new File("PieceImages/CyanN.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whiteRook = ImageIO.read(new File("PieceImages/CyanR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whiteBishop = ImageIO.read(new File("PieceImages/CyanB.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//MARK: - Black Pieces 

		try {
			blackPawn = ImageIO.read(new File("PieceImages/PurpleP.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			blackKing = ImageIO.read(new File("PieceImages/PurpleK.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			blackQueen = ImageIO.read(new File("PieceImages/PurpleQ.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			blackKnight = ImageIO.read(new File("PieceImages/PurpleN.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			blackRook = ImageIO.read(new File("PieceImages/PurpleR.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			blackBishop = ImageIO.read(new File("PieceImages/PurpleB.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}


