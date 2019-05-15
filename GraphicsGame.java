import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;

public abstract class GraphicsGame extends Game implements KeyListener {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public abstract String getName();

	public abstract Color getBackground();
}
