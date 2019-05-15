import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

// Description: Is the super class for all games with graphics components

public abstract class GraphicsGame extends Game implements KeyListener {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public abstract String getName();

	public abstract Color getBackground();
}
