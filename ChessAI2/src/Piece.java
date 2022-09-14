import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Piece{
	public int x = 5;
	public int y = 5;
	public boolean colour; //white true, black false
	public int type;
	public boolean showing = false;
	Image wr1Image;
	String wr1URL = "whiteRook.png";
	ArrayList<Integer> possibleXMoves = new ArrayList<Integer>();
	ArrayList<Integer> possibleYMoves = new ArrayList<Integer>();
	public boolean addedMoves = false;
	
	
	public Piece() {
		  wr1Image = Toolkit.getDefaultToolkit().getImage(wr1URL);
		
	}
	
	public void showOptions(Graphics g) {
		if(showing == true && type == 0) {
			if(type == 0) {
				if(addedMoves == false) {
					for(int i = x+1; i <= 7; i++) {
						possibleXMoves.add(i);
						possibleYMoves.add(y);
					}
					for(int i = x-1; i >= 0; i--) {
						possibleXMoves.add(i);
						possibleYMoves.add(y);
					}
					for(int i = y+1; i <= 7; i++) {
						possibleXMoves.add(x);
						possibleYMoves.add(i);
					}
					for(int i = y-1; i >= 0; i--) {
						possibleXMoves.add(x);
						possibleYMoves.add(i);
					}
					addedMoves = true;
				}
				
				for(int i = 0; i < possibleXMoves.size(); i++) {
					g.setColor(Color.RED);
					g.fillOval(possibleXMoves.get(i)*100+25,possibleYMoves.get(i)*100+25,50,50);
				}
			}
		}
	}
	
	public void movePiece() {
		
	}
	
	public void drawPiece(Graphics g) {
		g.drawImage(wr1Image,x*100+5, y*100+5, 90, 90, null);
	}
}
