import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Game {
	static JFrame f = new JFrame("hi");
	public static void main(String[] args) {
		Main main = new Main();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLayout(new BorderLayout());
		f.add(main, BorderLayout.CENTER);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.addMouseListener(main);
	}
	public JFrame getFrame() {
		return f;
	}
}
