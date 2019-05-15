import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

// Description: Is an easel for a given game

public class GameFrame extends JFrame {
	private static boolean MAX=Constants.MAX;
	
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private JFrame w;
	private Coordinates coords;
	
	public GameFrame( int xOff, int yOff, int x, int y) {
		width = x;
		height = y;
		coords = new Coordinates(xOff, yOff);
	}

	public void run(GraphicsGame g) {
		w = new JFrame(g.getName());
		if (!MAX) {
			w.setBounds(coords.getX(), coords.getY(), width, height);
		}
		else {
			w.setBounds(0,0,0,0);
			w.setSize(getMaximumSize());
		}
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsGame game = g;
		w.setBackground(g.getBackground());
		w.addKeyListener(game);
		Container c = w.getContentPane();
		c.add(game);
		w.setResizable(true);
		w.setVisible(true);
	}
	
	public void paint(Graphics g) {
		w.setResizable(false);
	}

	public Coordinates getDimensions() {
		Coordinates dimensions= new Coordinates(width,height);
		return dimensions;
	}
}
