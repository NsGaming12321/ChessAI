import java.awt.Color;
import java.awt.Graphics;

public class Board {
	public static final int tileSize = 100;
	public void drawBoard(Graphics g) {
		g.setColor(new Color(200,150,100));
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				g.fillRect(i*tileSize*2+tileSize, j*tileSize*2, tileSize, tileSize);
				g.fillRect(i*tileSize*2, j*tileSize*2+tileSize, tileSize, tileSize);
			}
		}
	}
}
