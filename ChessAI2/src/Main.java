import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Main extends JPanel implements Runnable, MouseListener{
	
	private static final int width = 800;
	private static final int height = 800;
	Thread thread;
	private boolean isRunning = false;
	boolean running;
	double updateRate = 1.0d/60.0d;
	long nextStatTime;
	int fps;
	int ups;
	
	public Main() {
		setPreferredSize(new Dimension(width,height));
		setFocusable(true);
		start();
	}
	
	public void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	
	public void run() {
		running = true;
		double accumulator = 0;
		long currentTime = System.currentTimeMillis();
		long lastUpdate = System.currentTimeMillis();
		double lastRenderTimeInSeconds = currentTime - lastUpdate;
		nextStatTime = System.currentTimeMillis() + 1000;
		
		while(running) {
			currentTime = System.currentTimeMillis();
			lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
			accumulator += lastRenderTimeInSeconds;
			lastUpdate = currentTime;
			
			while(accumulator > updateRate) {
				update();
				accumulator -= updateRate;
			}
			repaint();
			if(System.currentTimeMillis() > nextStatTime) {
				System.out.println(ups);
				System.out.println(fps);
				fps = 0;
				ups = 0;
				nextStatTime = System.currentTimeMillis() + 1000;
			}
		}
	}
	
	Board board = new Board();
	Piece wr1 = new Piece();
	
	public Piece getWr1() {
		return wr1;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		board.drawBoard(g);
		wr1.showOptions(g);
		wr1.movePiece();
		wr1.drawPiece(g);
		fps++;
	}


	public void update() {
		ups++;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(Math.floor(e.getX()/100) == wr1.x && Math.floor(e.getY()/100) == wr1.y && wr1.showing == false) {
			wr1.showing = true;
		}
		else if(Math.floor(e.getX()/100) == wr1.x && Math.floor(e.getY()/100) == wr1.y && wr1.showing == true) {
			wr1.showing = false;
		}
		for(int i = 0; i < wr1.possibleXMoves.size(); i++) {
			if(wr1.showing == true) {
				if(Math.floor(e.getX()/100) == wr1.possibleXMoves.get(i)) {
					if(Math.floor(e.getY()/100) == wr1.possibleYMoves.get(i)) {
						wr1.x = (int) Math.floor(e.getX()/100);
						wr1.y = (int) Math.floor((e.getY()-28)/100);
						wr1.possibleXMoves.clear();
						wr1.possibleYMoves.clear();
						wr1.addedMoves = false;
					}
				}
			}
		}		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
