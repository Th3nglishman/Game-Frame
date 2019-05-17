import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

// Description: Provides a basic class for all graphics based games to use

public abstract class GraphicsGame extends Game implements KeyListener {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public abstract String getName();

	public abstract Color getBackground();
}
