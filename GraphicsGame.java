import java.awt.Graphics;

public abstract class GraphicsGame extends Game {
	private static final long serialVersionUID = 1L;
	public abstract void paintComponet(Graphics g);
	public abstract String getName();
	public abstract void run();
	public abstract int getWindowWidth();
	public abstract int getWindowHeight();
}
