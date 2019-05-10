import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static void run(Game g) {
		JFrame w = new JFrame(g.getName());
		w.setBounds(100, 100, 640, 480);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Game game = g;
		w.setBackground(Color.WHITE);

		Container c = w.getContentPane();
		c.add(game);

		w.setResizable(true);
		w.setVisible(true);
		w.setBounds(100, 100, g.getWidth(), g.getHeight());
	}
}
